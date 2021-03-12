package com.golovanova.commands;

import java.util.ArrayDeque;

public class InfoCommand extends AbstractCommand {


    public InfoCommand() {
        super("info", "display information about the collection");
    }

    public void execute(ArrayDeque workers) {
        System.out.println(workers);
    }
}
