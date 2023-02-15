package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrder() {
        // Given
        PizzaOrder theOrder = new BasicPizza();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(10), calculatedCost);
        assertEquals("Pizza", description);
    }

    @Test
    public void testHamPizzaOrder() {
        // Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new HamDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
        assertEquals("Pizza with ham", description);
    }

    @Test
    public void testShrimpPizzaOrder() {
        // Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new ShrimpDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
        assertEquals("Pizza with shrimp", description);
    }

    @Test
    public void testEvilPizzaOrder() {
        // Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new EvilDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(16.66), calculatedCost);
        assertEquals("Pizza with pineapple", description);
    }

    @Test
    public void testHamMushroomExtraCheesePizzaOrder() {
        // Given
        PizzaOrder theOrder = new BasicPizza();
        theOrder = new HamDecorator(theOrder);
        theOrder = new MushroomsDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(25), calculatedCost);
        assertEquals("Pizza with ham with mushrooms with extra cheese", description);
    }
}
