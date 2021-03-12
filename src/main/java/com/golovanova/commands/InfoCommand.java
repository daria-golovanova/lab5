package com.golovanova.commands;

public class InfoCommand extends AbstractCommand {


    public InfoCommand() {
        super("info", "display information about the collection");
    }

    public boolean execute() {
        return false;
    }
}
