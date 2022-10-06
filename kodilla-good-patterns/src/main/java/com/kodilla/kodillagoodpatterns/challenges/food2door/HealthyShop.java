package com.kodilla.kodillagoodpatterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Vendor {
    private Map<String, Double> ourProducts = new HashMap<>();

    public HealthyShop() {
        ourProducts.put("lettuce", 38.47);
        ourProducts.put("apples", 56.14);
        ourProducts.put("leek", 26.67);
    }

    @Override
    public boolean process(String product, double amount) {
        if (this.ourProducts.containsKey(product) && this.ourProducts.get(product) >= amount) {
            System.out.println("Sending " + amount + "kg " + product);
            return true;
        }
        return false;
    }
}
