package com.kodilla.kodillagoodpatterns.challenges.productorder.delivery;

import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.Customer;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.Product;

public class UPS implements Delivery {
    public boolean deliver(Product product, int amount, Customer customer) {
        System.out.println(amount + "x " + product + " is being delivered to " + customer.getAddress());
        return true;
    }
}
