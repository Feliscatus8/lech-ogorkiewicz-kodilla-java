package com.kodilla.kodillaspringintro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawerTestSuite {
    @Test
    void testDoDrawingWithCircle() {
        //Given
        Drawer drawer = new Drawer(new Circle());

        //When
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a circle", result);
    }

    @Test
    void testDoDrawingWithTriangle() {
        //Given
        Drawer drawer = new Drawer(new Triangle());

        //When
        String result = drawer.doDrawing();

        //Then
        assertEquals("This is a triangle", result);
    }
}
