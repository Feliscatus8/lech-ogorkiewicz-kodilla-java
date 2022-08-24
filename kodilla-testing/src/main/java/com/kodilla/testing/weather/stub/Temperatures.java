package com.kodilla.testing.weather.stub;

import java.util.Map;

public interface Temperatures {
    //weather station ID/Celsius temperature
    Map<String, Double> getTemperatures();
}
