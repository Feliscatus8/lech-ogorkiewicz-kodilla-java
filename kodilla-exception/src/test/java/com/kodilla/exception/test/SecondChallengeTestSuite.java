package com.kodilla.exception.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {
    @Test
    void testProbabliIWillThrowAnException(){
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () ->assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.5, 2)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(4, 8)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5))
        );
    }
}
