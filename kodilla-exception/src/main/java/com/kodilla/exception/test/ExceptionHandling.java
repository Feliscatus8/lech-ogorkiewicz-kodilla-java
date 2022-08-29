package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try{
            System.out.println(secondChallenge.probablyIWillThrowException(0, 1));
        }catch (Exception e){
            System.out.println("Exception ocurred: " + e);
        }finally {
            System.out.println("Exception or not, here i am");
        }
    }
}
