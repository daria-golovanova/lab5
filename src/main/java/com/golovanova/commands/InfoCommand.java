package com.golovanova.commands;

public class InfoCommand extends AbstractCommand {


    public InfoCommand(String name, String description) {
        super("info",
                "display information about the collection");
    }

    public boolean execute() {
        return false;
    }
}
