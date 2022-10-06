package com.kodilla.kodillagoodpatterns.challenges.productorder.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameWarehouse implements Supply{
    private Map<Product, Integer> shelves = new HashMap<>();
    private List<OrderDto> transactions = new ArrayList<>();

    public boolean isAvailable(Product product, int amount) {
        return  (this.shelves.get(product) >= amount);
    }

    public void saveOrder(OrderDto order) {
        this.shelves.put(order.getProduct(), this.shelves.get(order.getProduct()) - order.getAmount());
        this.transactions.add(order);
    }
    public void delivery(Product product, int amount) {
        if (this.shelves.containsKey(product)) amount += this.shelves.get(product);
        this.shelves.put(product, amount);
    }
}
