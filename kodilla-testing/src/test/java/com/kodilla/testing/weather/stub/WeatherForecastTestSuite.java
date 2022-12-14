package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherForecastTestSuite {
    @Test
    void testCalculateForecastWithStub(){
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        assertEquals(5, quantityOfSensors);
    }
}
