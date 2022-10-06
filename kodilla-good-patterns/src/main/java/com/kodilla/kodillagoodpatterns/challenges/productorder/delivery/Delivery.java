package com.kodilla.kodillagoodpatterns.challenges.productorder.delivery;

import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.Customer;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.Product;

public interface Delivery {
    public boolean deliver(Product product, int amount, Customer customer);
}
