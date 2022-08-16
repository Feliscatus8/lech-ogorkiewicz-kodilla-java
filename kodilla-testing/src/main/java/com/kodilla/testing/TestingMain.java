package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Test jednostkowy klast SimpleUser:");
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        if(result.equals("theForumUser")){
            System.out.println("test OK");
        }else{
            System.out.println("Error!");
        }
        System.out.println("Testy jednostkowe klasy Calculator");
        Calculator calculator = new Calculator();
        int additionResult = calculator.add(16, 9);
        if(additionResult == 25){
            System.out.println("Add method test OK");
        }else{
            System.out.println("Error!");
        }
        int subtractionResult = calculator.subtract(16, 9);
        if(subtractionResult == 7){
            System.out.println("Subtract method test OK");
        }else{
            System.out.println("Error!");
        }
    }
}
