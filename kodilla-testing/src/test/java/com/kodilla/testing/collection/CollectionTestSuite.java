package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {
    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Suite: begin");

    }
    @AfterAll
    public static void afterAll(){
        System.out.println("Test Suite: end");
    }
    @DisplayName("Testing empty list")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        System.out.println("Testing empty list");
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Assertions.assertEquals(integerArrayList, oddNumbersExterminator.exterminate(integerArrayList));
    }
    @DisplayName("Testing normal list")
    @Test
    void testOddNumbersExterminatorNormalList(){
        System.out.println("Testing normal list");
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer[] integers = {4, 13, 8, 7, 16, 33};
        Integer[] resultIntegers = {4, 8, 16};
        List<Integer> integerList = Arrays.asList(integers);
        List<Integer> resultIntegerList = Arrays.asList(resultIntegers);
        Assertions.assertEquals(resultIntegerList, oddNumbersExterminator.exterminate(integerList));
    }
}
