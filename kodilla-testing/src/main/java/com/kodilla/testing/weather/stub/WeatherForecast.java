package com.kodilla.testing.weather.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }
    public Map<String, Double> calculateForecast(){
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }
    public double getAverage(){
        double sum = 0.0;
        int number = 0;
        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
        sum += temperature.getValue();
        number++;
        }
        return sum/number;
    }
    public double getMedian(){
        ArrayList<Double> temperatureValues = new ArrayList<Double>();
        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            temperatureValues.add(temperature.getValue());
        }
        Collections.sort(temperatureValues);
        int size = temperatureValues.size();
        if(size % 2 != 0){
            return temperatureValues.get((size - 1)/2);
        }
        return (temperatureValues.get((size/2)-1) + temperatureValues.get(size/2))/2;
    }
}
