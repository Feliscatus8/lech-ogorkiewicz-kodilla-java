package com.kodilla.kodillagoodpatterns.challenges.productorder.customers;

import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.CommunicationMethod;

public class Email implements CommunicationMethod {
    private final String emailAddress;

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void send(String message) {
        System.out.println("Sending message " + " to " + this.emailAddress);
    }
}
