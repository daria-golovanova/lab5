package com.golovanova.commands;

import com.golovanova.CollectionInfo;
import com.golovanova.data.DataSource;
import com.golovanova.data.LinesDataSource;
import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.model.Worker;
import com.golovanova.utility.CommandDecoder;
import com.golovanova.utility.FileManager;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand() {
        super("execute_script file_name", "read and execute the script from the specified " +
                "file. The script contains com.golovanova.commands in the same form as the user enters them interactively.");
    }

    public void execute(String filename, ArrayDeque<Worker> workers, CollectionInfo collectionInfo,
                        FileManager fileManager) {
        try {
            File file = new File(filename);
            if (!file.canRead())
                file.setReadable(true);


            List<String> strings = Files.readAllLines(file.toPath());
            LinesDataSource dataSource = new LinesDataSource(strings);

            HashSet<String> fileNames = new HashSet<String>();
            fileNames.add("1");

            while (!dataSource.endOfData()) {
                String line = dataSource.nextLine();
                choseCommand(line, dataSource, workers, collectionInfo, fileManager);
//                if (fileNames.contains(line.split(" ")[1])) {
//                    System.err.println("Recursion is prohibited!");
//                    continue;
//                }
//                if (line.contains("execute_script")) {
//                    fileNames.add(line.split(" ")[1]);
//                    if (fileNames.contains(line.split(" ")[1])) {
//                        System.err.println("Recursion is prohibited!");
//                        continue;
//                    }
//                }
            }
        } catch (Exception e) {
            System.err.println("File cannot be read!");
        }

    }

    public void choseCommand(String line,
                             DataSource dataSource,
                             ArrayDeque<Worker> workers,
                             CollectionInfo collectionInfo,
                             FileManager fileManager) {


        ArrayList<CommandType> history = new ArrayList<>();
        CommandType commandType = CommandDecoder.decode(line);
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
                new RemoveByIdCommand().execute(workers, Integer.parseInt(line.split(" ")[1]));
                break;
            case add:
                new AddCommand(dataSource).execute(workers);
                break;
            case average_of_salary:
                new AverageOfSalaryCommand().execute(workers);
                break;
            case clear:
                new ClearCommand().execute(workers);
                break;
            case execute_script:
                //System.out.println("Recursion is prohibited.");
                new ExecuteScriptCommand().execute(line.split(" ")[1], workers, collectionInfo, fileManager);
                break;
            case exit:
                new ExitCommand().execute();
                break;
            case remove_any_by_organization:
                new RemoveAnyByOrganizationCommand().execute(workers, line.split(" ")[1]);
                break;
            case remove_head:
                new RemoveHeadCommand().execute(workers);
                break;
            case remove_lower:
                try {
                    new RemoveLowerCommand().execute(line.split(" ")[1], workers);
                } catch (WorkerNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case filter_by_organization:
                new FilterByOrganizationCommand().execute(workers, line.split(" ")[1]);
                break;
            case save:
                new SaveCommand().execute(workers, fileManager, collectionInfo);
                break;
            case show:
                new ShowCommand().execute(workers);
                break;
            case update:
                try {
                    new UpdateCommand(dataSource).execute(workers);
                } catch (WorkerNotFoundException e) {
                    System.err.println("This worker does not exists!");
                }
                break;
            case no_command:
                System.out.println("No such command. Try again!");
                break;
            default:
                System.err.println("No such command. Try again!");
        }
    }
}
