package org.emeraldcraft.datastructures.hw.e159;

public class Task implements Comparable<Task> {
    private int priority;
    private String description;

    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;

    }

    @Override
    public int compareTo(Task o) {
        return this.priority - o.priority;
    }
    @Override
    public String toString() {
        return "Priority: " + priority + " | " + description;
    }

}
