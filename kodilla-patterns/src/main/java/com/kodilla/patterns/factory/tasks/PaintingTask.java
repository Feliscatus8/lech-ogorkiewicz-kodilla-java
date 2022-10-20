package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private final String taskName;
    private final String colour;
    private final String whatToPaint;
    private boolean executed = false;

    public PaintingTask(String taskName, String colour, String whatToPaint) {
        this.taskName = taskName;
        this.colour = colour;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        this.executed = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return this.executed;
    }

    public String getColour() {
        return colour;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }
}
