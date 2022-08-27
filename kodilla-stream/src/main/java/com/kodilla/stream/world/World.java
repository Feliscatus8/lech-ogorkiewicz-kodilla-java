package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

public final class World {
    private final List<Continent> continents;

    public World(List<Continent> continents) {
        this.continents = continents;
    }

    BigDecimal getPeopleQuantity(){
        BigDecimal population = continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return population;
    }
}
