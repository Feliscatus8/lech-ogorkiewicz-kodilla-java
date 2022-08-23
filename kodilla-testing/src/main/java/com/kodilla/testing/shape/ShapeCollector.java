package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapeList= new ArrayList<>();

    public void addFigure(Shape shape){
        this.shapeList.add(shape);
    }
    public void removeFigure(Shape shape){
        this.shapeList.remove(shape);
    }
    public Shape getFigure(int number) {
        if (number >= 0 && number < this.shapeList.size()) {
            return this.shapeList.get(number);
        }
        return null;
    }
    public String showFigures(){
        if(this.shapeList.size() > 0){
            String shapes = "";
            for (Shape shape: this.shapeList){
                if (shapes != ""){shapes += ", ";}
                shapes += shape.toString();
            }
            return shapes;
        }
        return null;}
}
