package com.golovanova.dto;

import com.golovanova.commands.AbstractCommand;

public class SimpleCommandMessage implements CommandMessage{
    private AbstractCommand abstractCommand;

    public SimpleCommandMessage(AbstractCommand abstractCommand) {
        this.abstractCommand = abstractCommand;
    }

    @Override
    public AbstractCommand getCommand() {
        return abstractCommand;
    }
}
