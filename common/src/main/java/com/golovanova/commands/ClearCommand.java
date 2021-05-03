package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.ArrayDeque;

public class ClearCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;
    public ClearCommand() {
        super(CommandType.clear);
    }

    public void execute(ArrayDeque<Worker> workers) {
        workers.clear();
    }
}
