package com.golovanova.model;

//import com.sun.istack.internal.NotNull;

import com.sun.istack.internal.NotNull;

import java.util.Objects;

public class Organization {
    private String name;
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null

    public Organization(@NotNull Long employeesCount, @NotNull OrganizationType type, @NotNull String name) {
        this.employeesCount = employeesCount;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public OrganizationType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return Objects.equals(employeesCount, that.employeesCount) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeesCount, type);
    }

    @Override
    public String toString() {
        return "Organization: " +
                "name: " + name +
                ", number of workers: " + employeesCount +
                ", type of organisation: " + type;
    }
}
