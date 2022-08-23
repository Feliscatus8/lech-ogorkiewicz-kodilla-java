package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double Field;

    public Circle(double field) {
        Field = field;
    }
    public String getShapeName(){return "Circle";}

    @Override
    public double getField() {
        return Field;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Field=" + Field +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.Field, Field) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(Field);
        return (int) (temp ^ (temp >>> 32));
    }
}
