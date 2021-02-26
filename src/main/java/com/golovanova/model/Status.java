package com.golovanova.model;

import java.util.Comparator;

public enum Status {
    REGULAR(2),
    HIRED(1),
    PROBATION(0);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Comparator<Status> getComparator() {
        Comparator<Status> comparator = new Comparator<Status>() {
            @Override
            public int compare(Status o1, Status o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        };

        return comparator;
    }
}
