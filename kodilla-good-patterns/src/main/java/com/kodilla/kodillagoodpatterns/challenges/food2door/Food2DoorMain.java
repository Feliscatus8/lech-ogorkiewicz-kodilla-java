package com.kodilla.kodillagoodpatterns.challenges.food2door;

public class Food2DoorMain {
    public static void main(String[] args) {
        Food2door food2door = new Food2door();
        food2door.addVendor("HealthyShop", new HealthyShop());
        food2door.addVendor("ExtraFoodShop", new ExtraFoodShop());
        food2door.addVendor("GlutenFreeShop", new GlutenFreeShop());
        food2door.order("ExtraFoodShop", "potatoes", 5.5);
        food2door.order("HealthyShop", "apples", 2.8);
        food2door.order("GlutenFreeShop", "carrot", 4.0);
    }
}
