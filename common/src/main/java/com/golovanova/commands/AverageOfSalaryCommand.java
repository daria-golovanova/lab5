package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayDeque;

public class AverageOfSalaryCommand extends AbstractCommand implements Serializable {
    private double averageSalary;
    static final long SerialVersionUID = -4862926644813433707L;

    public AverageOfSalaryCommand() {
        super(CommandType.average_of_salary);
    }


    public void execute(ArrayDeque<Worker> workers) {

        for (Worker w: workers) {
            averageSalary+= w.getSalary();
        }
        averageSalary = averageSalary/workers.size();

        System.out.println(averageSalary);
    }
}
