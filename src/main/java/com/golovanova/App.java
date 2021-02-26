package com.golovanova;

import com.golovanova.commands.*;
import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.model.Organization;
import com.golovanova.model.Worker;
import com.golovanova.utility.CommandDecoder;
import com.golovanova.utility.FileManager;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // CommandExecutor executor = new CommandExecutor();
        ArrayDeque<Worker> workers = new ArrayDeque<>();
        CollectionInfo collectionInfo = new CollectionInfo(workers);

        String filePath = "data.json";
        if(args.length > 0)
            filePath = args[0];

        File file = new File(filePath);
        if(file.isFile() && !file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileManager fileManager = new FileManager(file);
        workers = fileManager.readCollection();
        System.out.println("Use 'help' command for browsing the list of com.golovanova.commands.");
        while (true) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");


            // executor.execute(input)

             CommandType commandType = CommandDecoder.decode(input);
             switch(commandType) {
                 case remove_by_id: new RemoveByIdCommand().execute(workers, Integer.parseInt(split[1]));
                 break;
                 case add: new AddCommand().execute(workers);
                 break;
                 case average_of_salary: new AverageOfSalaryCommand().execute(workers);
                 case clear: new ClearCommand().execute(workers);
                 case execute_script: new ExecuteScriptCommand().execute("");
                 case exit: new ExitCommand().execute();
                 case remove_any_by_organization: new FilterByOrganizationCommand().execute(workers, split[1]);
                 case remove_head: new RemoveHeadCommand().execute(workers);
                 case remove_lower:
                     try {
                         new RemoveLowerCommand().execute(split[1], workers);
                     } catch (WorkerNotFoundException e) {
                         log.error("Worker with id={} not found. You can try again.", split[1], e);
                     }
                 case save: new SaveCommand().execute(workers, fileManager, collectionInfo);
                 case show: new ShowCommand().execute(workers);
                 case update:
                     try {
                         new UpdateCommand().execute(split[1], workers);
                     } catch (WorkerNotFoundException e) {
                         log.error("Worker with id={} not found. You can try again.", split[1], e);
                     }
             }



        }


//
//
//        List<Worker> workers = new ArrayList<>();
//        Collections.sort(workers);
//
//
//        Double x;
//        Float y;
//
//        x = scanner.nextDouble();
//        y = scanner.nextFloat();
//
//        if(x < 10)
//            x = null;
//
//        if(y < 10)
//            y = null;
//
//        Coordinates c = new Coordinates(x, y);
//        System.out.println();
    }
}
