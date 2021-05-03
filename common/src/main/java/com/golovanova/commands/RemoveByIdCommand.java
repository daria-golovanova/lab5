package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.ArrayDeque;

public class RemoveByIdCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public RemoveByIdCommand() {
        super(CommandType.remove_by_id);
    }

    public void execute(ArrayDeque<Worker> workers, int argument) {
            for (Worker w : workers) {
                if (w.getId() == argument) {
                    workers.remove(w);
                }
            }
    }
}
