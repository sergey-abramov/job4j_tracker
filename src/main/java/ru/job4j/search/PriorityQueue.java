package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var index = 0;
        for (var element1 : tasks) {
           if (element1.getPriority() > task.getPriority()) {
               break;
           }
           index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
