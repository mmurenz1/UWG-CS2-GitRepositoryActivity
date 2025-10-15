package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/**
 * Comparator for sorting Tasks in descending priority order (HIGH, MEDIUM, LOW).
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Descending implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        int priority1 = this.getPriorityValue(task1.getPriority());
        int priority2 = this.getPriorityValue(task2.getPriority());
        
        return Integer.compare(priority1, priority2);
    }
    
    private int getPriorityValue(Task.TaskPriority priority) {
        switch (priority) {
            case HIGH:
                return 1;
            case MEDIUM:
                return 2;
            case LOW:
                return 3;
            default:
                return 0;
        }
    }
}