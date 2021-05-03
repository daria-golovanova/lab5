package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.ArrayDeque;

public class RemoveHeadCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public RemoveHeadCommand() {
        super(CommandType.remove_head);
    }

    public void execute(ArrayDeque<Worker> workers) {
        System.out.println(workers.pollFirst());
    }
}
