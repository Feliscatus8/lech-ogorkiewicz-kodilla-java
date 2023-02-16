package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTestSuite {
    @Test
    void testUpdate(){
        //Given
        Participant leszek = new Participant("Leszek");
        Participant mruczek = new Participant("Mruczek");
        Participant filemon = new Participant("Filemon");
        Participant bonifacy = new Participant("Bonifacy");
        Participant klakier = new Participant("Klakier");

        Mentor piotr = new Mentor("Piotr");
        Mentor andrzej = new Mentor("Andrzej");

        leszek.registerObserver(piotr);
        mruczek.registerObserver(piotr);
        filemon.registerObserver(andrzej);
        bonifacy.registerObserver(andrzej);
        klakier.registerObserver(andrzej);

        //When
        leszek.addTask("facade");
        leszek.addTask("decorator");
        leszek.addTask("aspect");
        leszek.addTask("observer");
        mruczek.addTask("facade");
        mruczek.addTask("decorator");
        filemon.addTask("decorator");
        filemon.addTask("aspect");
        bonifacy.addTask("facade");
        bonifacy.addTask("decorator");
        klakier.addTask("observer");

        //Then
        assertEquals(6, piotr.getTasksToCheck());
        assertEquals(5, andrzej.getTasksToCheck());
    }

}