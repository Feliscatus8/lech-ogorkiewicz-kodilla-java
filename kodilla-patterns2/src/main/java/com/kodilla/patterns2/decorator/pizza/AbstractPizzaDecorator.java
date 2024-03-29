package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;

    protected AbstractPizzaDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }
}
