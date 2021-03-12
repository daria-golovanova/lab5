package com.golovanova.commands;

import com.golovanova.model.Worker;
import com.golovanova.scanner.WorkerScanner;

import java.util.ArrayDeque;

public class AddCommand extends AbstractCommand {
    public AddCommand() {
        super("add {element}", "add a new item to the collection");
    }

    private WorkerScanner workerScanner = new WorkerScanner();

    public void execute(ArrayDeque<Worker> workers) {
        Worker worker = workerScanner.scan();
        workers.add(worker);
    }
}
