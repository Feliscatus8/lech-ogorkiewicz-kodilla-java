package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    @Mock
    static private Temperatures temperaturesMock;
    @BeforeEach
    public void beforeEachTest(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Poznań", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }
    @Test
    void testCalculateForecastWithMock(){
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        assertEquals(5, quantityOfSensors);
    }
    @Test
    void testGetAverage(){
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        double average = weatherForecast.getAverage();

        assertEquals(25.56, average);
    }
    @Test
    void testMedianWhenOdd(){
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        double median = weatherForecast.getMedian();

        assertEquals(25.5, median);
    }
    @Test
    void testMedianWhenEven(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Poznań", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
        temperaturesMap.put("Gdynia", 25.7);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        double median = weatherForecast.getMedian();

        assertEquals(25.6, median);
    }
}
