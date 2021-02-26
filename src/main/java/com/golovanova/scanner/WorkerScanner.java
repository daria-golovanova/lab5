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
        Status status = statusScanner.scanEnum();
        Position position = positionScanner.scanEnum();
        Organization organization = organizationScanner.scan();



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
