package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "Shopping task";
    public static final String PAINTING = "Painting task";
    public static final String DRIVING = "Driving task";

    public final Task createTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Buy cat food", "Royal Canin Renal", 2.0);
            case PAINTING -> new PaintingTask("Painting cat toy", "black", "rattling mouse");
            case DRIVING -> new DrivingTask("Cat colony supply", "Moon", "Space shuttle");
            default -> null;
        };
    }
}
