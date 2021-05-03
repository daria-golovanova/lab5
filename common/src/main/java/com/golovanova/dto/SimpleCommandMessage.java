package com.golovanova.dto;

import com.golovanova.commands.CommandType;

public class SimpleCommandMessage implements CommandMessage {
    private CommandType commandType;

    public SimpleCommandMessage(CommandType commandType) {
        this.commandType = commandType;
    }

    @Override
    public CommandType getCommandType() {
        return commandType;
    }
}
