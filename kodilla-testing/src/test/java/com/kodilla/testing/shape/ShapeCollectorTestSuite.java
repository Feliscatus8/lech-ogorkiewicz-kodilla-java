package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests");
    }
    @AfterAll
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }
    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    class ShapesTests{
        @DisplayName("Testing the Circle")
        @Test
        void testCircle(){
            Circle circle = new Circle(6.4);

            String shape = circle.getShapeName();
            double field = circle.getField();

            assertEquals("Circle", shape);
            assertEquals(6.4, field);

        }
        @DisplayName("Testing the Square")
        @Test
        void testSquare(){
            Square square = new Square(12.8);

            String shape = square.getShapeName();
            Double field = square.getField();

            assertEquals("Square", shape);
            assertEquals(12.8, field);
        }@DisplayName("Testing the Triangle")
        @Test
        void testTriangle(){
            Triangle triangle = new Triangle(25.6);

            String shape = triangle.getShapeName();
            double field = triangle.getField();

            assertEquals("Triangle", shape);
            assertEquals(25.6, field);
        }
    }
    @Nested
    class CollectorTests{
        @DisplayName("Testing adding a Figure")
        @Test
        void testAddFigure(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(12.8);

            shapeCollector.addFigure(square);
            Shape figure = shapeCollector.getFigure(0);

            assertEquals(square, figure);
        }
        @DisplayName("Testing removing a Figure")
        @Test
        void testRemoveFigure(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(12.8);
            shapeCollector.addFigure(square);

            shapeCollector.removeFigure(square);
            Shape figure = shapeCollector.getFigure(0);

            assertNull(figure);
        }
        @DisplayName("Testing showing all Figures")
        @Test
        void testShowFigures(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(6.4);
            Square square = new Square(12.8);
            Triangle triangle = new Triangle(25.6);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);

            String figures = shapeCollector.showFigures();

            assertEquals("Circle{Field=6.4}, Square{Field=12.8}, Triangle{Field=25.6}", figures);
        }
    }
}
