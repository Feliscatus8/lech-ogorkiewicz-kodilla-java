package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    @Test
    void testShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.createTask(TaskFactory.SHOPPING);
        //Then
        assertEquals("Buy cat food", shoppingTask.getTaskName());
        assertFalse(shoppingTask.isTaskExecuted());
        shoppingTask.executeTask();
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.createTask(TaskFactory.PAINTING);
        //Then
        assertEquals("Painting cat toy", paintingTask.getTaskName());
        assertFalse(paintingTask.isTaskExecuted());
        paintingTask.executeTask();
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.createTask(TaskFactory.DRIVING);
        //Then
        assertEquals("Cat colony supply", drivingTask.getTaskName());
        assertFalse(drivingTask.isTaskExecuted());
        drivingTask.executeTask();
        assertTrue(drivingTask.isTaskExecuted());
    }
}
