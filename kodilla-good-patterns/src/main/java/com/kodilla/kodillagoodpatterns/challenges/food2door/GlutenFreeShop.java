package com.kodilla.kodillagoodpatterns.challenges.food2door;

public class GlutenFreeShop implements Vendor {
    @Override
    public boolean process(String product, double amount) {
        if (product.equalsIgnoreCase("gluten")) return false;
        System.out.println("Sending " + amount + "kg " + product);
        return true;
    }
}
