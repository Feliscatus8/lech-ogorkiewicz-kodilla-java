package com.kodilla.testing.shape;

public class Square implements Shape{
    private double Field;

    public Square(double field) {
        Field = field;
    }
    public String getShapeName(){return "Square";}

    @Override
    public double getField() {
        return Field;
    }

    @Override
    public String toString() {
        return "Square{" +
                "Field=" + Field +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.Field, Field) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(Field);
        return (int) (temp ^ (temp >>> 32));
    }
}
