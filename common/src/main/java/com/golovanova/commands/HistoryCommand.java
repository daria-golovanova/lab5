package com.golovanova.commands;

import java.util.ArrayList;

public class HistoryCommand extends AbstractCommand {
    private final int COMMAND_HISTORY_SIZE = 11;

    public HistoryCommand() {
        super("history", "print the last 11 golovanova.golovanova.commands (without their arguments)");
    }


    public void execute(ArrayList<CommandType> history, CommandType commandType) {
        while (history.size() > 11) {
            history.remove(0);
        }

        for (CommandType command : history) {
            System.out.println(command);
        }
    }
}
