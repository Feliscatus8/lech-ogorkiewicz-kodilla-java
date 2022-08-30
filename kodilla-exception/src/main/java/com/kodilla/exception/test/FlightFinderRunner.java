package com.kodilla.exception.test;

public class FlightFinderRunner {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();

        try {
            boolean canIFly = flightFinder.findFlight(new Flight("Poznań", "Przeworno"));
            if (canIFly) System.out.println("I can fly!");
        }catch (RouteNotFoundException e){
            System.out.println("exception occured: " + e);
        }
    }
}
