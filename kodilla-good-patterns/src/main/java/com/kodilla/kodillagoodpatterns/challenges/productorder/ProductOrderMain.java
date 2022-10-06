package com.kodilla.kodillagoodpatterns.challenges.productorder;

import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.Email;
import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.RegisteredCustomer;
import com.kodilla.kodillagoodpatterns.challenges.productorder.delivery.UPS;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.Game;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.GameWarehouse;

public class ProductOrderMain {
    public static void main(String[] args) {
        Game baldur = new Game("77698275", "Baldur's Gate", "RPG", "DVD", 49.99);
        UPS upsPoland = new UPS();
        RegisteredCustomer customer = new RegisteredCustomer("Hobbit111", "Bilbo", "Baggins",
                new Email("bilbo_baggins@bag.end"));
        customer.setAddress("Bag End, Hobbiton, Middle Earth");
        GameWarehouse localWarehouse = new GameWarehouse();
        localWarehouse.delivery(baldur, 1000);
        ProductOrderService productOrderService = new ProductOrderService(baldur, 1, upsPoland, customer);
        productOrderService.process(localWarehouse);
    }
}
