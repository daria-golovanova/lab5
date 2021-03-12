package com.golovanova.scanner;

import com.golovanova.model.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class WorkerScanner {
    private EnumScanner<Position> positionScanner = new EnumScanner<>(Position.class);
    private EnumScanner<Status> statusScanner = new EnumScanner<>(Status.class);
    private OrganisationScanner organizationScanner = new OrganisationScanner();

    public Worker scan() {
        System.out.println("Input data of worker: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double x = scanner.nextDouble();
        float y = scanner.nextFloat();
        Coordinates coordinates = new Coordinates(x,y);
        float salary = scanner.nextFloat();
        Status status = null;
        try {
            status = statusScanner.scanEnum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Position position = null;
        try {
            position = positionScanner.scanEnum();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
