package com.golovanova.commands;

import com.golovanova.model.Organization;
import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class RemoveByIdCommand extends AbstractCommand {
    public RemoveByIdCommand() {
        super("remove_by_id id", "delete an item from the collection by its id");
    }

    public void execute(ArrayDeque<Worker> workers, int argument) {
            for (Worker w : workers) {
                if (w.getId() == argument) {
                    workers.remove(w);
                }
            }
    }
}
