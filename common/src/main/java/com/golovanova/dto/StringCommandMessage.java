package com.golovanova.dto;

import com.golovanova.commands.AbstractCommand;

public class StringCommandMessage implements CommandMessage {
    private AbstractCommand abstractCommand;
    private String argument;

    public StringCommandMessage(AbstractCommand abstractCommand, String argument) {
        this.abstractCommand = abstractCommand;
        this.argument = argument;
    }

    @Override
    public AbstractCommand getCommand() {
        return abstractCommand;
    }

    public String getArgument() {
        return argument;
    }
}
