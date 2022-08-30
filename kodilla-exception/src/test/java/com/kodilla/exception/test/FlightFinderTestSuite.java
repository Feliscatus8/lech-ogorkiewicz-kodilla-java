package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightFinderTestSuite {
    @Test
    void testFlightFinder(){
        //Given
        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Poznań", "Kraków");
        Flight flight2 = new Flight("Poznań", "Kościan");
        Flight flight3 = new Flight("Poznań", "Przeworno");

        //When & Then
        assertAll(
                () -> assertTrue(flightFinder.findFlight(flight1)),
                () -> assertDoesNotThrow(() -> flightFinder.findFlight(flight1)),
                () -> assertFalse(flightFinder.findFlight(flight2)),
                () -> assertDoesNotThrow(() -> flightFinder.findFlight(flight2)),
                () -> assertThrows(RouteNotFoundException.class, () -> flightFinder.findFlight(flight3))
        );

    }
}
