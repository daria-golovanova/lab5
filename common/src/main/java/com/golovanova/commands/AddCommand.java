package com.golovanova.commands;

import com.golovanova.data.DataSource;
import com.golovanova.data.ConsoleDataSource;
import com.golovanova.model.Worker;
import com.golovanova.scanner.WorkerScanner;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Scanner;

public class AddCommand extends AbstractCommand implements Serializable {
    private DataSource dataSource;
    private WorkerScanner workerScanner;
    static final long SerialVersionUID = -4862926644813433707L;

    public AddCommand() {
        super(CommandType.add);
        dataSource = new ConsoleDataSource(new Scanner(System.in));
        workerScanner = new WorkerScanner(dataSource);
    }

    public AddCommand(DataSource dataSource) {
        super(CommandType.add);
        this.dataSource = dataSource;
        workerScanner = new WorkerScanner(dataSource);
    }

    public void execute(ArrayDeque<Worker> workers) {
        Worker worker = workerScanner.scan();
        workers.add(worker);
    }
}
