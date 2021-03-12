package com.golovanova;

import com.golovanova.commands.*;
import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.model.Worker;
import com.golovanova.utility.CommandDecoder;
import com.golovanova.utility.FileManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ctrl+C Handled!");
            }
        }));

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Worker> workers = new ArrayDeque<>();
        CollectionInfo collectionInfo = new CollectionInfo(workers);

        String filePath = "data.json";
        if (args.length > 0)
            filePath = args[0];

        File file = new File(filePath);
        if (file.isFile() && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




//        ObjectMapper objectMapper = new ObjectMapper();
//        Coordinates coordinates = new Coordinates(13d, 14f);
//        Organization organization = new Organization(45l, OrganizationType.COMMERCIAL, "BMW");
//        Worker car = new Worker("Daria", coordinates, 123f, Position.ENGINEER, Status.HIRED, organization);
//        Worker car2 = new Worker("Ania", coordinates, 123f, Position.ENGINEER, Status.HIRED, organization);
//        ArrayDeque<Worker> workers1 = new ArrayDeque<>();
//        workers.add(car);
//        workers.add(car2);
        FileManager fileManager = new FileManager(file);
//
//        AddCommand add = new AddCommand();
//        System.out.println(add);

        workers = fileManager.readCollection();

        //System.out.println(workers.stream().map(Worker::toString).collect(Collectors.joining("\n\n")));
        System.out.println("Use 'help' command for browsing the list of com.golovanova.commands.");
        ArrayList<CommandType> history = new ArrayList<>();
        while (true) {
            System.out.println("Enter command: ");
            String input = scanner.nextLine();
            String[] split = input.split(" ");

            CommandType commandType = CommandDecoder.decode(input);
            history.add(commandType);
            switch (commandType) {
                case help:
                    new HelpCommand().execute();
                    break;
                case info:
                    new InfoCommand().execute(workers);
                    break;
                case history:
                    new HistoryCommand().execute(history, commandType);
                    break;
                case remove_by_id:
                    new RemoveByIdCommand().execute(workers, Integer.parseInt(split[1]));
                    break;
                case add:
                    new AddCommand().execute(workers);
                    break;
                case average_of_salary:
                    new AverageOfSalaryCommand().execute(workers);
                    break;
                case clear:
                    new ClearCommand().execute(workers);
                    break;
                case execute_script:
                    new ExecuteScriptCommand().execute("");
                    break;
                case exit:
                    new ExitCommand().execute();
                    break;
                case remove_any_by_organization:
                    new FilterByOrganizationCommand().execute(workers, split[1]);
                    break;
                case remove_head:
                    new RemoveHeadCommand().execute(workers);
                    break;
                case remove_lower:
                    try {
                        new RemoveLowerCommand().execute(split[1], workers);
                    } catch (WorkerNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case filter_by_organization:
                    new FilterByOrganizationCommand().execute(workers, split[1]);
                    break;
                case save:
                    new SaveCommand().execute(workers, fileManager, collectionInfo);
                    break;
                case show:
                    new ShowCommand().execute(workers);
                    break;
                case update:
                    try {
                        new UpdateCommand().execute(split[1], workers);
                    } catch (WorkerNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case no_command:
                    System.out.println("No such command. Try again.");
                    break;
                default:
                    System.err.println("Такой команды не существует. Попробуйте ещё раз.");
            }
        }
    }
}
