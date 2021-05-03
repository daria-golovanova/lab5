package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.ArrayDeque;

public class ShowCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public ShowCommand() {
        super(CommandType.show);
    }

    public void execute(ArrayDeque<Worker> workers) {
        for (Worker w : workers) {
            System.out.println(w.toString());
        }
    }
}
