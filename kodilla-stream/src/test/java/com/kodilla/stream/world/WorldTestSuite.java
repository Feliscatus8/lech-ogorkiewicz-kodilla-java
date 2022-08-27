package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity(){
        //Given
        Country germany = new Country(new BigDecimal(83783942));
        Country unitedKingdom = new Country(new BigDecimal(67886011));
        Country france = new Country(new BigDecimal(65273511));
        Country italy = new Country(new BigDecimal(60461826));
        Country spain = new Country(new BigDecimal(46754778));
        List<Country> europeList = new ArrayList<>();
        europeList.add(germany);
        europeList.add(unitedKingdom);
        europeList.add(france);
        europeList.add(italy);
        europeList.add(spain);

        Country china = new Country(new BigDecimal(1439323776));
        Country india = new Country(new BigDecimal(1407563842));
        Country indonesia = new Country(new BigDecimal(273523615));
        Country pakistan = new Country(new BigDecimal(220892340));
        Country bangladesh = new Country(new BigDecimal(164689383));
        List<Country> asiaList = new ArrayList<>();
        asiaList.add(china);
        asiaList.add(india);
        asiaList.add(indonesia);
        asiaList.add(pakistan);
        asiaList.add(bangladesh);

        Country usa = new Country(new BigDecimal(331002651));
        Country mexico = new Country(new BigDecimal(128932753));
        Country canada = new Country(new BigDecimal(37742154));
        List<Country> northAmericaList = new ArrayList<>();
        northAmericaList.add(usa);
        northAmericaList.add(mexico);
        northAmericaList.add(canada);

        Country brazil = new Country(new BigDecimal(212559417));
        Country colombia = new Country(new BigDecimal(50882891));
        Country argentina = new Country(new BigDecimal(45195774));
        Country peru = new Country(new BigDecimal(32971854));
        Country venezuela = new Country(new BigDecimal(28435940));
        List<Country> southAmericaList = new ArrayList<>();
        southAmericaList.add(brazil);
        southAmericaList.add(colombia);
        southAmericaList.add(argentina);
        southAmericaList.add(peru);
        southAmericaList.add(venezuela);

        Country nigeria = new Country(new BigDecimal(206139589));
        Country ethiopia = new Country(new BigDecimal(114963588));
        Country egypt = new Country(new BigDecimal(102334404));
        Country congo = new Country(new BigDecimal(89561403));
        Country tanzania = new Country(new BigDecimal(59308690));
        List<Country> africaList = new ArrayList<>();
        africaList.add(nigeria);
        africaList.add(ethiopia);
        africaList.add(egypt);
        africaList.add(congo);
        africaList.add(tanzania);

        Country australia = new Country(new BigDecimal(25499884));
        List<Country> australiaList = new ArrayList<>();
        australiaList.add(australia);

        Continent europe = new Continent(europeList);
        Continent asia = new Continent(asiaList);
        Continent northAmerica = new Continent(northAmericaList);
        Continent southAmerica = new Continent(southAmericaList);
        Continent africa = new Continent(africaList);
        Continent australiaCont = new Continent(australiaList);
        List<Continent> continents = new ArrayList<>();
        continents.add(europe);
        continents.add(asia);
        continents.add(northAmerica);
        continents.add(southAmerica);
        continents.add(africa);
        continents.add(australiaCont);

        World world = new World(continents);

        //When
        BigDecimal worldPopulation = world.getPeopleQuantity();
        BigDecimal expectedWorldPopulation = new BigDecimal(5295684016L);

        //Then
        assertEquals(expectedWorldPopulation, worldPopulation);

    }
}
