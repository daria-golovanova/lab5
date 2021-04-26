package com.golovanova.dto;

import com.golovanova.commands.AbstractCommand;

import java.io.Serializable;

public interface CommandMessage extends Serializable {
    AbstractCommand getCommand();
}
