package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Participant implements Student {
    private final String name;
    private List<String> tasks;

    private List<Teacher> teachers;

    public Participant(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void notifyObservers() {
        for (Teacher teacher : teachers) {
            teacher.update(this);
        }
    }

    @Override
    public void removeObserver(Teacher teacher) {
        teachers.remove(teacher);
    }

    public String getName() {
        return name;
    }

    public List<String> getTasks() {
        return tasks;
    }
}
