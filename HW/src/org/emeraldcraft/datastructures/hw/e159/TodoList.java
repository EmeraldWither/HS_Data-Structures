package org.emeraldcraft.datastructures.hw.e159;

import java.util.PriorityQueue;

/**
 * TodoList
 */
public class TodoList {
    private final PriorityQueue<Task> queue = new PriorityQueue<>(); 
    public void addTask(Task task) {
        queue.add(task);
    }
    public Task getTask() {
        return queue.remove();
    }
}