package com.kodilla.kodillagoodpatterns.challenges.productorder.products;

import com.kodilla.kodillagoodpatterns.challenges.productorder.products.OrderDto;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.Product;

public interface Supply {
    public boolean isAvailable(Product product, int amount);
    public void saveOrder(OrderDto order);
}
