package com.golovanova.scanner;

import com.golovanova.model.*;

import java.util.Scanner;

public class WorkerScanner {
    private EnumScanner<Position> positionScanner = new EnumScanner<>(Position.class);
    private EnumScanner<Status> statusScanner = new EnumScanner<>(Status.class);
    private OrganisationScanner organizationScanner = new OrganisationScanner();

    public Worker scan() {
        System.out.println("Input data of worker: ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        //TODO
        System.out.println("Input coordinate x: ");
        double x = scanner.nextDouble();
        System.out.println("Input coordinate y: ");
        float y = scanner.nextFloat();
        Coordinates coordinates = new Coordinates(x,y);
        System.out.println("Input salary: ");
        float salary = scanner.nextFloat();
        System.out.println("Input status: ");
        Status status = null;
        try {
            status = statusScanner.scanEnum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Input position: ");
        Position position = null;
        try {
            position = positionScanner.scanEnum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Input Organization: ");
        Organization organization = null;
        try {
            organization = organizationScanner.scan();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Worker worker = new Worker(
                name,
                coordinates,
                salary,
                position,
                status,
                organization);

        return worker;
    }
}
