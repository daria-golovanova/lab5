package com.golovanova;

import com.golovanova.commands.*;
import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.model.Worker;
import com.golovanova.utility.CommandDecoder;
import com.golovanova.utility.FileManager;
import com.google.gson.JsonParseException;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
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
        ArrayDeque<Worker> workers = new ArrayDeque<>();
        CollectionInfo collectionInfo = new CollectionInfo(workers);

        String filePath = "data.json";
        //TODO
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

         try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fileReader);
            String line = buffer.readLine();
            String[] splitDot = line.split(",");
            for (int i = 0; i < splitDot.length; i++) {
                if (splitDot[i].contains("\"position\"")) {
                    switch (splitDot[i]) {
                        case "\"position\":\"ENGINEER\"":
                        case "\"position\":\"HEAD_OF_DIVISION\"":
                        case "\"position\":\"BAKER\"":
                        case "\"position\":\"COOK\"":
                            break;
                        default: {
                            System.out.println("Error! Field \"Position\" is incorrect!");
                            System.exit(-1);
                        }
                    }

                }

                if (splitDot[i].contains("status")) {
                    switch (splitDot[i]) {
                        case "\"status\":\"HIRED\"":
                        case "\"status\":\"REGULAR\"":
                        case "\"status\":\"PROBATION\"":
                            break;
                        default: {
                            System.out.println("Error! Field \"Status\" is incorrect!");
                            System.exit(-1);
                        }
                    }
                }
                if (splitDot[i].contains("\"type\"")) {
                    switch (splitDot[i]) {
                        case "\"type\":\"COMMERCIAL\"}":
                        case "\"type\":\"GOVERNMENT\"}":
                        case "\"type\":\"TRUST\"}":
                        case "\"type\":\"PRIVATE_LIMITED_COMPANY\"}":
                        case "\"type\":\"OPEN_JOINT_STOCK_COMPANY\"}":
                            break;
                        default: {
                            System.out.println("Error! Field \"OrganisationType\" is incorrect!");
                            System.exit(-1);
                        }
                    }
                }
            }

         } catch (FileNotFoundException exception) {
             System.err.println("The boot file was not found!");
         } catch (NoSuchElementException exception) {
             System.err.println("The boot file is empty!");
         } catch (JsonParseException | NullPointerException exception) {
             System.err.println("The required collection was not found in the boot file!" + exception);
         } catch (IllegalStateException | IOException exception) {
             System.err.println("Unexpected error!");
             System.exit(0);
         }

        FileManager fileManager = new FileManager(file);
        workers = fileManager.readCollection();
        //System.out.println(workers.stream().map(Worker::toString).collect(Collectors.joining("\n\n")));
        System.out.println("Use 'help' command for browsing the list of com.golovanova.commands.");
        ArrayList<CommandType> history = new ArrayList<>();
        if (!file.canWrite()) {
            System.out.println("This file cannot be overwritten!");
        }
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
                    new InfoCommand().execute(workers, collectionInfo);
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
                    new ExecuteScriptCommand().execute(split[1], workers, collectionInfo, fileManager);
                    break;
                case exit:
                    new ExitCommand().execute();
                    break;
                case remove_any_by_organization:
                    new RemoveAnyByOrganizationCommand().execute(workers, split[1]);
                    break;
                case remove_head:
                    new RemoveHeadCommand().execute(workers);
                    break;
                case remove_lower:
                    try {
                        new RemoveLowerCommand().execute(split[1], workers);
                    } catch (WorkerNotFoundException e) {
                        System.out.println("Worker was not found!");
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
                        new UpdateCommand().execute(workers);
                    } catch (WorkerNotFoundException e) {
                        System.out.println("Worker was not found!");
                    }
                    break;
                case no_command:
                    System.out.println("No such command. Try again.");
                    break;
                default:
                    System.err.println("No such command. Try again.");
            }
        }
    }
}
