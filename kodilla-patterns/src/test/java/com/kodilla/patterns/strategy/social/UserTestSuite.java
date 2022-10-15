package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        //Given
        User steven = new Millenials("Steven Links");
        User john = new YGeneration("John Hemerald");
        User jenny = new ZGeneration("Jenny Spring");

        //When
        String stevenShares = steven.share();
        System.out.println("Steven shares: " + stevenShares);
        String johnShares = john.share();
        System.out.println("John shares: " + johnShares);
        String jennyShares = jenny.share();
        System.out.println("Jenny shares: " + jennyShares);

        //Then
        assertEquals("Facebook", stevenShares);
        assertEquals("Twitter", johnShares);
        assertEquals("Snapchat", jennyShares);
    }

    @Test
    void testIndividualSharingStrategy(){
        //Given
        User sarah = new ZGeneration("Sarah Harding");

        //When
        String sarahShares = sarah.share();
        System.out.println("Sarah shares: " + sarahShares);
        sarah.setSocialPublisher(new FacebookPublisher());
        sarahShares = sarah.share();
        System.out.println("Sarah shares: " + sarahShares);

        //Then
        assertEquals("Facebook", sarahShares);
    }
}
