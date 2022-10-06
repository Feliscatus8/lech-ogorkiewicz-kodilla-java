package com.kodilla.kodillagoodpatterns.challenges.food2door;

import java.util.HashSet;
import java.util.Set;

public class ExtraFoodShop implements Vendor {
    private final Set<String> ourProducts = new HashSet<>();
    public ExtraFoodShop() {
        this.ourProducts.add("potatoes");
        this.ourProducts.add("cabbage");
    }
    @Override
    public boolean process(String product, double amount) {
        if (this.ourProducts.contains(product)) {
            System.out.println("Sending " + amount + "kg " + product);
            return true;
        }
        return false;
    }
}
