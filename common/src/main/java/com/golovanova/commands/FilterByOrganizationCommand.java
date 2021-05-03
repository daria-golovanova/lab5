package com.golovanova.commands;

import com.golovanova.model.Worker;

import java.io.Serializable;
import java.util.ArrayDeque;

public class FilterByOrganizationCommand extends AbstractCommand implements Serializable {
    static final long SerialVersionUID = -4862926644813433707L;

    public FilterByOrganizationCommand() {
        super(CommandType.filter_by_organization);
    }

    public void execute (ArrayDeque<Worker> workers, String organisationName) {
        for (Worker w : workers) {
            if (w.getOrganization().getName().equals(organisationName)) {
                System.out.println(w);
            }
        }
    }
}
