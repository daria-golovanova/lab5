package com.golovanova.data;

import java.util.Scanner;

public class ConsoleDataSource implements DataSource {
    private final Scanner scanner;

    public ConsoleDataSource(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public Integer nextInt() {
        return scanner.nextInt();
    }

    @Override
    public Float nextFloat() {
        return scanner.nextFloat();
    }

    @Override
    public Double nextDouble() {
        return scanner.nextDouble();
    }

    @Override
    public Long nextLong() {
        return scanner.nextLong();
    }
}
