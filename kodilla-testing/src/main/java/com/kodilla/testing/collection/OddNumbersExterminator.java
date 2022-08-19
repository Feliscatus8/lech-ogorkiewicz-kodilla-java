package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers){
        ArrayList<Integer> result = new ArrayList<>();
        for(int number: numbers){
            if (number%2==0){
                result.add(number);
            }
        }
        return result;
    }
}
