package com.golovanova.commands;

import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.model.Worker;
//import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Iterator;

//@Slf4j //Slf4j, logback.xml - читать
public class RemoveLowerCommand extends AbstractCommand {
    public RemoveLowerCommand() {
        super("remove_lower {element_id}", "remove all items from the collection that are " +
                "smaller than the specified one");
    }


    public void execute(String elementIdStr, ArrayDeque<Worker> workers) throws WorkerNotFoundException {
        Integer elementIdInt = Integer.parseInt(elementIdStr);
        Worker worker = null;
        for (Worker w: workers) {
            if(w.getId().equals(elementIdInt)) {
                worker = w;
            }
        }

        if (worker == null) {
            throw new WorkerNotFoundException("wrong id: " + elementIdStr);
        }

        Iterator<Worker> iterator = workers.iterator();

        while(iterator.hasNext()){
            Worker w = iterator.next();
            if (w.compareTo(worker) == -1) {
            iterator.remove(); }
        }

        //        for (Worker w : workers) {
//            if (w.compareTo(worker) == -1) {
//                workers.remove(w);
//            }
//        }
    }
}
