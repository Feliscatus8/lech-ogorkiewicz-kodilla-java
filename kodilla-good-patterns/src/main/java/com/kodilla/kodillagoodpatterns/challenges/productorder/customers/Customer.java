package com.kodilla.kodillagoodpatterns.challenges.productorder.customers;

public interface Customer {
    public String getUsername();
    public CommunicationMethod getCommunicationMethod();
    public String getAddress();
}
