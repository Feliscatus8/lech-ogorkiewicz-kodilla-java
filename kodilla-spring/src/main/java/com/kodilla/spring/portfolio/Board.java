package com.kodilla.spring.portfolio;

import java.util.List;

public class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDoTask(String task) {
        this.toDoList.addTask(task);
    }

    public void addInProgressTask(String task) {
        this.inProgressList.addTask(task);
    }

    public void addDoneTask(String task) {
        this.doneList.addTask(task);
    }

    public List<String> getToDoTasks() {
        return this.toDoList.getTasks();
    }

    public List<String> getInProgressTasks() {
        return this.inProgressList.getTasks();
    }

    public List<String> getDoneTasks() {
        return this.doneList.getTasks();
    }
}
