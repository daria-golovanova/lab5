package com.golovanova.commands;

import com.golovanova.model.Organization;
import com.golovanova.model.Worker;

import java.util.ArrayDeque;

public class FilterByOrganizationCommand extends AbstractCommand {
    public FilterByOrganizationCommand() {
        super("filter_by_organization organization", "output elements whose organization" +
                " field value is equal to the specified value");
    }


    public void execute (ArrayDeque<Worker> workers, String organisationName) {
        for (Worker w : workers) {
            if (w.getOrganization().equals(organisationName)) {
                System.out.println(w);
            }
        }
    }
}
