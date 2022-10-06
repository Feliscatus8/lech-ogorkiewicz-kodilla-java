package com.kodilla.kodillagoodpatterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class Food2door {
    private final Map<String, Vendor> vendors = new HashMap<>();

    public void order(String shopName, String productName, double amount) {
        boolean orderProcessed = this.vendors.get(shopName).process(productName, amount);
        if (orderProcessed) System.out.println("Your " + productName + " will soon be delivered!\n");
    }

    public void addVendor(String name, Vendor vendor) {
        this.vendors.put(name, vendor);
    }
}
