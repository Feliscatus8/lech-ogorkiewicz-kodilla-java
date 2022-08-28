package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage(){
        //Given
        int[] numbers = {4, 2, 2, 6, 1, 4, 4, 4, 7, 4, 8, 2, 4, 3, 13, 4, 2, 6, 4, 6};

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(4.5, average);
    }
}
