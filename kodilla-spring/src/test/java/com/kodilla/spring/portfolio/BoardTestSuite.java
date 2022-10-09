package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {
    @Autowired
    private Board board;

    @Test
    void testAddToDoList() {
        //Given
        //When
        board.addToDoTask("feed the cat");
        String task = board.getToDoTasks().get(0);

        //Then
        assertEquals("feed the cat", task);
    }

    @Test
    void testAddInProgressTask() {
        //Given
        //When
        board.addInProgressTask("pet the cat");
        String task = board.getInProgressTasks().get(0);

        //Then
        assertEquals("pet the cat", task);
    }

    @Test
    void testAddDoneTask() {
        //Given
        //When
        board.addDoneTask("clean the litterbox");
        String task = board.getDoneTasks().get(0);

        //Then
        assertEquals("clean the litterbox", task);
    }
}
