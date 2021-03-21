package com.golovanova.commands;

import com.golovanova.data.ConsoleDataSource;
import com.golovanova.data.DataSource;
import com.golovanova.model.Worker;
import com.golovanova.scanner.WorkerScanner;

import java.util.ArrayDeque;
import java.util.Scanner;

public class AddCommand extends AbstractCommand {
    private DataSource dataSource;
    private WorkerScanner workerScanner;

    public AddCommand() {
        super("add {element}", "add a new item to the collection");
        dataSource = new ConsoleDataSource(new Scanner(System.in));
        workerScanner = new WorkerScanner(dataSource);
    }

    public AddCommand(DataSource dataSource) {
        super("add {element}", "add a new item to the collection");
        this.dataSource = dataSource;
        workerScanner = new WorkerScanner(dataSource);
    }

    public void execute(ArrayDeque<Worker> workers) {
        Worker worker = workerScanner.scan();
        workers.add(worker);
    }
}
