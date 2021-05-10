package com.golovanova;


import com.golovanova.commands.CommandType;
import com.golovanova.data.ConsoleDataSource;
import com.golovanova.data.DataSource;
import com.golovanova.dto.*;
import com.golovanova.model.Worker;
import com.golovanova.net.ClientRequest;
import com.golovanova.net.Sender;
import com.golovanova.scanner.WorkerScanner;
import com.golovanova.utility.CollectionInfo;
import com.golovanova.utility.CommandDecoder;
import com.golovanova.utility.FileManager;
import com.golovanova.utility.RecursionChecker;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    private RecursionChecker recursionChecker = new RecursionChecker();
    private InetAddress inetAddress;
    private int port;

    private DataSource dataSource;
    private WorkerScanner workerScanner;
    private Sender sender;

    public Client(String hostname, int port) throws UnknownHostException {
        inetAddress = InetAddress.getByName(hostname);
        this.port = port;
        dataSource = new ConsoleDataSource(new Scanner(System.in));
        this.workerScanner = new WorkerScanner(dataSource);
        sender = new Sender();
    }

    public static void main(String[] args) throws UnknownHostException {
        new Client("localhost", 5252).start(args);
    }

    private void start(String[] args) {
        DatagramClient client = new DatagramClient();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                    System.out.println("Shutting 123 down...");
                } catch (NoSuchElementException e) {
                    System.err.println("CTRL+D Program stops");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("CTRL+D Program stops");
                }
            }
        });

        Scanner scanner = new Scanner(System.in);
        List<Worker> workers = new ArrayList<>();
        CollectionInfo collectionInfo = new CollectionInfo(workers);

        String filePath = "data.json";

        if (args.length > 0)
            filePath = args[0];

        File file = new File(filePath);
        if (file.isFile() && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("New file was created!");
            }
        }


        FileManager fileManager = new FileManager(file);
        workers = fileManager.readCollection();
//
//        System.out.print("Введите порт: ");
//        try {
//            port = Integer.parseInt(scanner.nextLine());
//        } catch (NumberFormatException e) {
//            System.err.println("Порт должен быть целым числом от 0 до 65535, клиент будет отключен.");
//            System.exit(-1);
//        }
//        try {
//            receiver = new Receiver(port, true);
//            receiver.startListening();
//        } catch (IOException e) {
//            System.out.println("Не получилось запустить клиент: " + e.toString());
//        }
//
//        System.out.println("Добро пожаловать!\n"  +
//                "Чтобы получить справку по командам, введите команду help.\n");

        //System.out.println(workers.stream().map(Worker::toString).collect(Collectors.joining("\n\n")));
        //System.out.println("Use 'help' command for browsing the list of golovanova.golovanova.commands.");
        ArrayList<CommandType> history = new ArrayList<>();
        if (!file.canWrite()) {
            System.out.println("This file cannot be overwritten!");
        }
        while (true) {
            System.out.println("Enter command: ");
            String input = scanner.nextLine();
            String[] split = input.split(" ");

            CommandType commandType = CommandDecoder.decode(input);

            if (commandType == CommandType.execute_script) {
                try {
                    if (recursionChecker.checkRecursionIsPresent(split[1])) {
                        System.out.println("Recursion is prohibited!");
                        continue;
                    }
                } catch (IOException e) {
                    System.out.println("Problems with file: " + e.getMessage());
                    System.exit(-1);
                }
            }

            history.add(commandType);

            switch (commandType) {
                case help:
                    CommandMessage commandMessageHelp = new SimpleCommandMessage(commandType);
                    ClientRequest clientRequestHelp = new ClientRequest(inetAddress, port, commandMessageHelp);
                    sender.send(clientRequestHelp);
                    break;
                case info:
                    CommandMessage commandMessageInfo = new SimpleCommandMessage(commandType);
                    ClientRequest clientRequestInfo = new ClientRequest(inetAddress, port, commandMessageInfo);
                    sender.send(clientRequestInfo);
                    break;
                case history:
                    CommandMessage commandMessageHistory = new SimpleCommandMessage(commandType);
                    ClientRequest clientRequestHistory = new ClientRequest(inetAddress, port, commandMessageHistory);
                    sender.send(clientRequestHistory);
                    break;
                case remove_by_id:
                    CommandMessage commandMessageRemoveById = new StringCommandMessage(commandType, split[1]);
                    ClientRequest clientRequestRemoveById = new ClientRequest(inetAddress, port, commandMessageRemoveById);
                    sender.send(clientRequestRemoveById);
                    break;
                case add:
                    Worker worker = workerScanner.scan();
                    Payload payloadAdd = new Payload(worker);
                    CommandMessage commandMessageAdd = new PayloadCommandMessage(commandType, payloadAdd);
                    ClientRequest clientRequestAdd = new ClientRequest(inetAddress, port, commandMessageAdd);
                    sender.send(clientRequestAdd);
                    break;
                case average_of_salary:
                    CommandMessage commandMessageAverageOfSalary = new SimpleCommandMessage(commandType);
                    ClientRequest clientRequestAverageOfSalary = new ClientRequest(inetAddress, port, commandMessageAverageOfSalary);
                    sender.send(clientRequestAverageOfSalary);
                    break;
                case clear:
                    CommandMessage commandMessageClear = new SimpleCommandMessage(commandType);
                    ClientRequest clientRequestClear = new ClientRequest(inetAddress, port, commandMessageClear);
                    sender.send(clientRequestClear);
                    break;
                case execute_script:
                    CommandMessage commandMessageExecuteScript = new StringCommandMessage(commandType, split[1]);
                    ClientRequest clientRequestExecuteScript = new ClientRequest(inetAddress, port, commandMessageExecuteScript);
                    sender.send(clientRequestExecuteScript);
                    break;
                case exit:
                    System.exit(0);
                    break;
                case remove_any_by_organization:
                    CommandMessage commandMessageRemoveByAnyOrg = new StringCommandMessage(commandType, split[1]);
                    ClientRequest clientRequestRemoveByAnyOrg = new ClientRequest(inetAddress, port, commandMessageRemoveByAnyOrg);
                    sender.send(clientRequestRemoveByAnyOrg);
                    break;
                case remove_head:
                    CommandMessage commandMessageRemoveHead = new SimpleCommandMessage(commandType);
                    ClientRequest clientRequestRemoveHead = new ClientRequest(inetAddress, port, commandMessageRemoveHead);
                    sender.send(clientRequestRemoveHead);
                    break;
                case remove_lower:
                    CommandMessage commandMessageRemoveLower = new StringCommandMessage(commandType, split[1]);
                    ClientRequest clientRequestRemoveLower = new ClientRequest(inetAddress, port, commandMessageRemoveLower);
                    sender.send(clientRequestRemoveLower);
                    break;
                case filter_by_organization:
                    CommandMessage commandMessageFilterByOrg = new StringCommandMessage(commandType, split[1]);
                    ClientRequest clientRequestFilterByOrg = new ClientRequest(inetAddress, port, commandMessageFilterByOrg);
                    sender.send(clientRequestFilterByOrg);
                    break;
                case show:
                    CommandMessage commandMessageShow = new SimpleCommandMessage(commandType);
                    ClientRequest clientRequestShow = new ClientRequest(inetAddress, port, commandMessageShow);
                    sender.send(clientRequestShow);
                    break;
                case update:
                    Worker workerUpdate = workerScanner.scan();
                    Payload payloadUpdate = new Payload(workerUpdate);
                    CommandMessage commandMessageUpdate = new PayloadCommandMessage(commandType, payloadUpdate);
                    ClientRequest clientRequestUpdate = new ClientRequest(inetAddress, port, commandMessageUpdate);
                    sender.send(clientRequestUpdate);
                    break;
                default:
                    System.err.println("No such command. Try again.");
            }
        }
    }
}
