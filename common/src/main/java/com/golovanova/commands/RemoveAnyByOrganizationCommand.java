package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class RemoveAnyByOrganizationCommand extends AbstractCommand {
    public RemoveAnyByOrganizationCommand() {
        super("remove_any_by_organization organization", "remove one element from the " +
                "collection whose organization field value is equivalent to the specified one");
    }


    public void execute(ArrayDeque<Worker> workers, String organizationName) {
        workers.removeIf(w -> w.getOrganization().getName().equals(organizationName));
    }
}
