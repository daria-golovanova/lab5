package com.golovanova.commands;

import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.data.ConsoleDataSource;
import com.golovanova.data.DataSource;
import com.golovanova.model.Worker;
import com.golovanova.scanner.SpecialWorkerScanner;

import java.util.ArrayDeque;
import java.util.Scanner;

public class UpdateCommand extends AbstractCommand {
    private DataSource dataSource;
    private SpecialWorkerScanner workerScanner;

    public UpdateCommand() {
        super("update id {element}", "update the value of a collection " +
                "element whose id is equal to the specified one");
        dataSource = new ConsoleDataSource(new Scanner(System.in));
        workerScanner = new SpecialWorkerScanner(dataSource);
    }

    public UpdateCommand(DataSource dataSource) {
        super("update id {element}", "update the value of a collection " +
                "element whose id is equal to the specified one");
        this.dataSource = dataSource;
        workerScanner = new SpecialWorkerScanner(dataSource);
    }

    public void execute(ArrayDeque<Worker> workers) throws WorkerNotFoundException {
        Worker worker = workerScanner.scan();
        try {
            for (Worker w : workers) {
                if (w.getId().equals(worker.getId())) {
                    w.setCoordinates(worker.getCoordinates());
                    w.setCreationDate(worker.getCreationDate());
                    w.setName(worker.getName());
                    w.setOrganization(worker.getOrganization());
                    w.setPosition(worker.getPosition());
                    w.setStatus(worker.getStatus());
                    w.setSalary(worker.getSalary());
                    w.setStartDate(worker.getStartDate());
                }
            }
        } catch (NullPointerException exception) {
            System.err.println("Worker is null!");
        }
    }
}
