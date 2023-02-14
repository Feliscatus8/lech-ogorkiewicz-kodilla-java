package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {
    private final int id;
    private final String name;
    private final List<Employee> employees;

    public CompanyDto(int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
