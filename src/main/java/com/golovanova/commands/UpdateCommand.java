package com.golovanova.commands;

import com.golovanova.exceptions.WorkerNotFoundException;
import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class UpdateCommand extends AbstractCommand {
    public UpdateCommand() {
        super("update id {element}", "update the value of a collection " +
                "element whose id is equal to the specified one");
    }

    public void execute(String elementIdStr, ArrayDeque<Worker> workers) throws WorkerNotFoundException {
        Integer elementIdInt = Integer.parseInt(elementIdStr);
        Worker worker = null;
        for (Worker w: workers) {
            if(w.getId().equals(elementIdInt)) {
                worker = w;
            }
        }

        if (worker == null) {
            throw new WorkerNotFoundException("wrong id: " + elementIdStr);
        }
        for (Worker w: workers) {
            if(w.getId().equals(worker.getId())) {
                w.setCoordinates(worker.getCoordinates());
                w.setCreationDate(worker.getCreationDate());
                w.setName(worker.getName());
                w.setOrganization(worker.getOrganization());
                w.setPosition(worker.getPosition());
                w.setStatus(worker.getStatus());
                w.setSalary(worker.getSalary());
                w.setStartDate(worker.getStartDate());
            }
        }
    }
}
