package com.golovanova.scanner;

import com.golovanova.data.DataSource;
import com.golovanova.model.*;

import java.util.InputMismatchException;

public class WorkerScanner {
    private final DataSource dataSource;

    private EnumScanner<Position> positionScanner;
    private EnumScanner<Status> statusScanner;
    private OrganisationScanner organizationScanner;
    private CoordinatesScanner coordinatesScanner;

    public WorkerScanner(DataSource dataSource) {
        this.dataSource = dataSource;
        positionScanner = new EnumScanner<>(dataSource, Position.class);
        statusScanner = new EnumScanner<>(dataSource, Status.class);
        organizationScanner = new OrganisationScanner(dataSource);
        coordinatesScanner = new CoordinatesScanner(dataSource);
    }


    public Worker scan() {
        System.out.println("Input data of worker: ");
        System.out.println("Input name: ");
        String name = dataSource.nextLine();
        Coordinates coordinates = null;
        while (coordinates == null) {
            try {
                coordinates = coordinatesScanner.scanCoordinates();
            } catch (Exception e) {
                System.err.println("Incorrect input! Try again.");
            }
        }
        System.out.println("Input salary: ");
        float salary = 0f;
        while (salary == 0f) {
            try {
                salary = dataSource.nextFloat();
            } catch (InputMismatchException e) {
                System.err.println("Incorrect input! Try again.");
            }
        }
        System.out.println("All statuses: REGULAR, HIRED, PROBATION");
        Status status = null;
        while (status == null) {
            try {
                status = statusScanner.scanEnum();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Не получилось считать Status!");
            }
        }
        System.out.println("All positions: LEAD_DEVELOPER, HEAD_OF_DIVISION, ENGINEER, BAKER, COOK");
        Position position = null;
        while (position == null) {
            try {
                position = positionScanner.scanEnum();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Не получилось считать Position!");
            }
        }
        System.out.println("All OrganisationTypes: COMMERCIAL, GOVERNMENT, TRUST, " +
                "PRIVATE_LIMITED_COMPANY, PEN_JOINT_STOCK_COMPANY");
        Organization organization = null;
        while (organization == null) {
            try {
                organization = organizationScanner.scan();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Не получилось считать Organization!");
            }
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
