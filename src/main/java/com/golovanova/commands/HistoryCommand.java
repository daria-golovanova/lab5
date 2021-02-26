package com.golovanova.commands;

public class HistoryCommand extends AbstractCommand {
    private final int COMMAND_HISTORY_SIZE = 11;

    public HistoryCommand(String name, String description) {
        super("history", "print the last 11 com.golovanova.commands (without their arguments)");
    }


    public boolean execute() {
        return false;
    }
}
