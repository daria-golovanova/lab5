package com.golovanova.commands;

import com.golovanova.model.Worker;
import com.golovanova.scanner.WorkerScanner;

import java.util.ArrayDeque;

public class AddCommand extends AbstractCommand {
    public AddCommand() {
        super("add {element}", "add a new item to the collection");
    }

    private WorkerScanner workerScanner;

    public void execute(ArrayDeque<Worker> workers) {
        Worker worker = workerScanner.scan();

//        Scanner scanner = new Scanner(System.in);
//        this.name = scanner.nextLine();
//        this.x = scanner.nextDouble();
//        this.y = scanner.nextFloat();
//        Coordinates coordinates = new Coordinates(x,y);
//        this.salary = scanner.nextFloat();
//        this.status = scanner.next();
//        this.position = scanner.next();
//        this.organization = scanner.next();
//
//        Worker worker = new Worker(id, name, coordinates, creationDate, salary, startDate, position, status, organization);

        workers.add(worker);
    }
}
