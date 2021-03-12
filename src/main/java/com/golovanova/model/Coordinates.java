package com.golovanova.model;

//import com.sun.istack.internal.NotNull;

import com.sun.istack.internal.NotNull;
import lombok.Getter;

import java.util.Objects;

public class Coordinates {
    private static Double maxX = 721d; // - можно доставать из файлов .properties
    @Getter
    private Double x; //Максимальное значение поля: 721, Поле не может быть null
    private Float y; //Поле не может быть null

    /**
     * @param x should not be null
     * @param y should not be null
     */
    public Coordinates(@NotNull Double x, @NotNull Float y) {
        // assert x != null;
        this.x = Math.min(x, maxX);
        this.y = y;
    }

//    public Double getX() {
//        return x;
//    }

    public Float getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }
}
