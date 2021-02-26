package com.golovanova.scanner;

import com.golovanova.model.Coordinates;

import java.util.Scanner;

public class CoordinatesScanner {
    public Coordinates scanCoordinates() {
        System.out.println("Input coordinates: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input x: ");
        Double x = scanner.nextDouble();
        System.out.println("Input y: ");
        Float y = scanner.nextFloat();

        return new Coordinates(x, y);
    }
}
