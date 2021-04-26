package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class ClearCommand extends AbstractCommand {
    public ClearCommand() {
        super("clear", "clear the collection");
    }

    public void execute(ArrayDeque<Worker> workers) {
        workers.clear();
    }
}
