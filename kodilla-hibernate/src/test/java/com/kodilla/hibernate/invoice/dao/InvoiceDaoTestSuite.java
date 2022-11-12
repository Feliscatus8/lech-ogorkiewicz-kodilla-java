package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
@Transactional
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product food = new Product("Cat food");
        Product litter = new Product("Cat litter");
        Product toy = new Product("Cat toy");

        Item foodItem = new Item(food, new BigDecimal(128.99), 2);
        Item litterItem = new Item(litter, new BigDecimal(49.99), 4);
        Item toyItem = new Item(toy, new BigDecimal(19.99), 10);

        food.getItems().add(foodItem);
        litter.getItems().add(litterItem);
        toy.getItems().add(toyItem);

        Invoice invoice = new Invoice("3372/2022");
        invoice.getItems().add(foodItem);
        invoice.getItems().add(litterItem);
        invoice.getItems().add(toyItem);

        foodItem.setInvoice(invoice);
        litterItem.setInvoice(invoice);
        toyItem.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        try {
            invoiceDao.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }
    }
}
