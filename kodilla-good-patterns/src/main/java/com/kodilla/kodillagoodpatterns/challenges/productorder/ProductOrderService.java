package com.kodilla.kodillagoodpatterns.challenges.productorder;

import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.Customer;
import com.kodilla.kodillagoodpatterns.challenges.productorder.delivery.Delivery;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.OrderDto;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.Product;
import com.kodilla.kodillagoodpatterns.challenges.productorder.products.Supply;

public class ProductOrderService {
    private final Product product;
    private final Delivery delivery;
    private final Customer customer;
    private final int amount;

    public ProductOrderService(final Product product,
                           final int amount,
                           final Delivery delivery,
                           final Customer customer) {
        this.product = product;
        this.amount = amount;
        this.delivery = delivery;
        this.customer = customer;
    }

    public OrderDto process(Supply supply) {
        if (supply.isAvailable(this.product, this.amount)) {
            this.delivery.deliver(this.product, this.amount, this.customer);
            this.customer.getCommunicationMethod().send("Order processed successfully!");
            return new OrderDto(product, amount, customer);
        }
        this.customer.getCommunicationMethod().send("Product unavailable");
        return null;
    }
}
