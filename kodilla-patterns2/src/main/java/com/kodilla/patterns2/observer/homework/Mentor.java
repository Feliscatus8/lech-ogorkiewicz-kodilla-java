package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observable;
import com.kodilla.patterns2.observer.forum.Observer;

public class Mentor implements Teacher {
    private String name;
    private int tasksToCheck;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Participant participant) {
        System.out.println(name + ": " + participant.getName() + " added a new task to check \n" +
                "(total tasks: " + tasksToCheck);
        tasksToCheck ++;
    }

    public String getName() {
        return name;
    }

    public int getTasksToCheck() {
        return tasksToCheck;
    }
}
