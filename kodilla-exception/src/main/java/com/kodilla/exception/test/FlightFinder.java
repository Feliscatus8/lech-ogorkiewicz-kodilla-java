package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private Map<String, Boolean> airports = new HashMap<>();

    public FlightFinder(){
        airports.put("Poznań", true);
        airports.put("Gdańsk", true);
        airports.put("Kraków", true);
        airports.put("Szczecin", true);
        airports.put("Swarzędz", false);
        airports.put("Kościan", false);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        try {
            if (!airports.get(flight.getDepartureAirport())) return false;
            return airports.get(flight.getArrivalAirport());
        }catch (Exception e){
            throw new RouteNotFoundException("Airport not found");
        }
    }
}
