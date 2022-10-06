package com.kodilla.kodillagoodpatterns.challenges.productorder.products;

import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.Customer;

public class OrderDto {
    private Product product;
    private int amount;
    private Customer customer;

    public OrderDto(Product product, int amount, Customer customer) {
        this.product = product;
        this.amount = amount;
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }
}
