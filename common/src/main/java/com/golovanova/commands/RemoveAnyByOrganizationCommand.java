package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.ArrayDeque;

public class RemoveAnyByOrganizationCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public RemoveAnyByOrganizationCommand() {
        super(CommandType.remove_any_by_organization);
    }


    public void execute(ArrayDeque<Worker> workers, String organizationName) {
        workers.removeIf(w -> w.getOrganization().getName().equals(organizationName));
    }
}
