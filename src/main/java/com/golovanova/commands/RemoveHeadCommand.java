package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class RemoveHeadCommand extends AbstractCommand {
    public RemoveHeadCommand() {
        super("remove_head", "print the first item in the collection and delete it");
    }

    public void execute(ArrayDeque<Worker> workers) {
        workers.pollFirst();
    }
}
