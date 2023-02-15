package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizza implements PizzaOrder {
    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(10);
    }
}
