package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(3)
                .sauce("barbecue")
                .ingredient("shrimp")
                .ingredient("chilli")
                .ingredient("onion")
                .ingredient("cheese")
                .build();
        System.out.println(bigmac);
        //When
        String bun = bigmac.getBun();
        int numberOfBurgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        int numberOfIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals("sesame", bun);
        assertEquals(3, numberOfBurgers);
        assertEquals("barbecue", sauce);
        assertEquals(4, numberOfIngredients);
    }
}
