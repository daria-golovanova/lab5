package com.golovanova.scanner;


import com.golovanova.model.Organization;
import com.golovanova.model.OrganizationType;

import java.util.Scanner;

public class OrganisationScanner {
    private EnumScanner<OrganizationType> organizationTypeScanner = new EnumScanner<>(OrganizationType.class);

    public Organization scan() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input organisation's data: ");
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input employees count: ");
        Long employeesCount = scanner.nextLong();
        OrganizationType type = organizationTypeScanner.scanEnum();

        Organization organization = new Organization(employeesCount, type, name);

        return organization;
    }
}
