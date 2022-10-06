package com.kodilla.kodillagoodpatterns.challenges.productorder.customers;

import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.CommunicationMethod;
import com.kodilla.kodillagoodpatterns.challenges.productorder.customers.Customer;

public class RegisteredCustomer implements Customer {
    private final String username;
    private final String firstName;
    private final String surname;
    private CommunicationMethod communicationMethod;
    private String address;

    public RegisteredCustomer(String username, String firstName, String surname, CommunicationMethod communicationMethod) {
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
        this.communicationMethod = communicationMethod;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public CommunicationMethod getCommunicationMethod() {
        return communicationMethod;
    }

    public String getAddress() {
        return address;
    }

    public void setCommunicationMethod(CommunicationMethod communicationMethod) {
        this.communicationMethod = communicationMethod;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
