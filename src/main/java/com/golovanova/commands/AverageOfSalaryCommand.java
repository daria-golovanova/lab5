package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class AverageOfSalaryCommand extends AbstractCommand {
    public AverageOfSalaryCommand() {
        super("average_of_salary", "output the average value of the salary" +
                " field for all items in the collection");
    }

    private double averageSalary;

    public double execute(ArrayDeque<Worker> workers) {

        for (Worker w: workers) {
            averageSalary+= w.getSalary();
        }
        averageSalary = averageSalary/workers.size();

        return averageSalary;
    }
}
