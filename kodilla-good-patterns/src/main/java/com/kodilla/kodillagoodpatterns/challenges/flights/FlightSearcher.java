package com.kodilla.kodillagoodpatterns.challenges.flights;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlightSearcher {
    private Map<String, Set<String>> flights = new HashMap<>();

    public FlightSearcher() {
        Set<String> destinationsFromPoznan = new HashSet<>();
        destinationsFromPoznan.add("Kraków");
        destinationsFromPoznan.add("Gdańsk");
        destinationsFromPoznan.add("Szczecin");
        destinationsFromPoznan.add("Wrocław");
        this.flights.put("Poznań", destinationsFromPoznan);
        Set<String> destinationsFromKrakow = new HashSet<>();
        destinationsFromKrakow.add("Poznań");
        destinationsFromKrakow.add("Warszawa");
        destinationsFromKrakow.add("Wrocław");
        destinationsFromKrakow.add("Bydgoszcz");
        this.flights.put("Kraków", destinationsFromKrakow);
        Set<String> destinationsFromGdansk = new HashSet<>();
        destinationsFromGdansk.add("Poznań");
        destinationsFromGdansk.add("Warszawa");
        destinationsFromGdansk.add("Wrocław");
        destinationsFromGdansk.add("Szczecin");
        this.flights.put("Gdańsk", destinationsFromGdansk);
        Set<String> destinationsFromSzczecin = new HashSet<>();
        destinationsFromSzczecin.add("Poznań");
        destinationsFromSzczecin.add("Gdańsk");
        this.flights.put("Szczecin", destinationsFromSzczecin);
        Set<String> destinationsFromWroclaw = new HashSet<>();
        destinationsFromWroclaw.add("Poznań");
        destinationsFromWroclaw.add("Warszawa");
        destinationsFromWroclaw.add("Gdańsk");
        this.flights.put("Wrocław", destinationsFromWroclaw);
        Set<String> destinationsFromWarsaw = new HashSet<>();
        destinationsFromWarsaw.add("Kraków");
        destinationsFromWarsaw.add("Gdańsk");
        destinationsFromWarsaw.add("Bydgoszcz");
        this.flights.put("Warszawa", destinationsFromWarsaw);
        Set<String> destinationsFromBydgoszcz = new HashSet<>();
        destinationsFromBydgoszcz.add("Kraków");
        destinationsFromBydgoszcz.add("Warszawa");
        this.flights.put("Bydgoszcz", destinationsFromBydgoszcz);
    }

    public void destinations(String origin) {
        this.flights.get(origin).stream()
                .forEach(System.out::println);
    }

    public void origins(String destination) {
        this.flights.entrySet().stream()
                .filter(origin -> origin.getValue().contains(destination))
                .forEach(origin -> System.out.println(origin.getKey()));
    }

    public void travel(String origin, String stopover, String destination) {
        if (this.flights.get(origin).contains(stopover) && this.flights.get(stopover).contains(destination)) {
            System.out.println("Travel available");
        } else System.out.println("Travel unavailable");
    }
}
