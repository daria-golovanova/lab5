package com.golovanova.dto;

import com.golovanova.commands.AbstractCommand;
import com.golovanova.model.Worker;

import java.util.List;

public class PayloadCommandMessage implements CommandMessage {
    private AbstractCommand abstractCommand;
    private Payload payload;

    public PayloadCommandMessage(AbstractCommand abstractCommand, Payload payload) {
        this.abstractCommand = abstractCommand;
        this.payload = payload;
    }

    @Override
    public AbstractCommand getCommand() {
        return abstractCommand;
    }

    public Payload getPayload() {
        return payload;
    }
}
