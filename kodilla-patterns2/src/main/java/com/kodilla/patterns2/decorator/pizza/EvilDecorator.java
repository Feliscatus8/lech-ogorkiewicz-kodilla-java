package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class EvilDecorator extends AbstractPizzaDecorator {
    public EvilDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with pineapple";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(6.66));
    }
}
