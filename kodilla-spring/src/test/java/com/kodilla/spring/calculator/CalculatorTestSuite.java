package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    void testCalculatorAdd(){
        //Given

        //When
        double result = calculator.add(7.5, 8.5);

        //Then
        assertEquals(16, result);
    }

    @Test
    void testCalculatorSub(){
        //Given

        //When
        double result = calculator.sub(18.5, 8.1);

        //Then
        assertEquals(10.4, result);
    }

    @Test
    void testCalculatorMul(){
        //Given

        //When
        double result = calculator.mul(8.0, 2.5);

        //Then
        assertEquals(20.0, result);
    }

    @Test
    void testCalculatorDiv(){
        //Given

        //When
        double result = calculator.div(64.0, 8.0);

        //Then
        assertEquals(8.0, result);
    }
}
