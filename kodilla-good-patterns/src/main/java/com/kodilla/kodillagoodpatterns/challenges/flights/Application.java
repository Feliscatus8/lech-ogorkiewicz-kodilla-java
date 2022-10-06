package com.kodilla.kodillagoodpatterns.challenges.flights;

public class Application {
    public static void main(String[] args) {
        FlightSearcher searcher = new FlightSearcher();
        System.out.println("Where can I fly from Poznań?");
        searcher.destinations("Poznań");
        System.out.println("\nWhere can I fly to Gdańsk from?");
        searcher.origins("Gdańsk");
        System.out.println("\nCan I fly from Szczecin to Wrocław through Gdańsk?");
        searcher.travel("Szczecin", "Gdańsk", "Wrocław");
        System.out.println("\nCan I fly from Kraków to Warszawa through Poznań?");
        searcher.travel("Kraków", "Poznań", "Warszawa");
    }
}
