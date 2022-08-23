package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double Field;

    public Triangle(double field) {
        Field = field;
    }
    public String getShapeName(){return "Triangle";}

    @Override
    public double getField() {
        return Field;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "Field=" + Field +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        return Double.compare(triangle.Field, Field) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(Field);
        return (int) (temp ^ (temp >>> 32));
    }
}
