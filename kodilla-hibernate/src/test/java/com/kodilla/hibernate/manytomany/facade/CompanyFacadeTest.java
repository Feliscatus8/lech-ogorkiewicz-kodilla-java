package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyFacadeTest {
    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void findCompanies() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //When
        List<Company> companies = companyFacade.findCompanies("ter");
        List<Company> nonCompanies = companyFacade.findCompanies("lamb");

        //Then
        assertEquals(2, companies.size());
        assertEquals(0, nonCompanies.size());

        //CleanUp
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);
    }

    @Test
    void findEmployees() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        int jsId = johnSmith.getId();
        int scId = stephanieClarckson.getId();
        int lkId = lindaKovalsky.getId();

        //When
        List<Employee> employees = companyFacade.findEmployees("val");
        List<Employee> nonEmployees = companyFacade.findEmployees("glamb");

        //Then
        assertEquals(1, employees.size());
        assertEquals(0, nonEmployees.size());

        //CleanUp
        employeeDao.deleteById(jsId);
        employeeDao.deleteById(scId);
        employeeDao.deleteById(lkId);
    }
}