package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class ShowCommand extends AbstractCommand {
    public ShowCommand() {
        super("show", "output all elements of the collection " +
                "in a string representation to the standard output stream");
    }


    public void execute(ArrayDeque<Worker> workers) {
        for (Worker w : workers) {
            System.out.println(w.toString());
        }
    }
}
