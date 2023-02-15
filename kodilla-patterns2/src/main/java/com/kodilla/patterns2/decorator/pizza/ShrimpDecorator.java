package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ShrimpDecorator extends AbstractPizzaDecorator {
    public ShrimpDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with shrimp";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }
}
