package com.golovanova.dto;

import com.golovanova.commands.CommandType;

import java.io.Serializable;

public interface CommandMessage extends Serializable {
    CommandType getCommandType();
}
