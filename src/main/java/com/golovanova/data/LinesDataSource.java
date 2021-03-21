package com.golovanova.data;

import java.util.Arrays;
import java.util.List;

public class LinesDataSource implements DataSource {
    private final List<String> data;
    private int cursor = 0;

    public LinesDataSource(List<String> data) {
        this.data = data;
    }

    public LinesDataSource(String string) {
        this.data = Arrays.asList(string.split("\n"));
    }

    @Override
    public String nextLine() {
        String line = data.get(cursor);
        cursor++;
        return line;
    }

    @Override
    public Integer nextInt() {
        return null;
    }

    @Override
    public Float nextFloat() {
        return null;
    }

    @Override
    public Double nextDouble() {
        return null;
    }

    @Override
    public Long nextLong() {
        return null;
    }
}
