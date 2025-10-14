package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

    @Test
    void testHighBeforeMedium() {
        Descending comparator = new Descending();
        Task highTask = new Task("High Priority", "Description", TaskPriority.HIGH);
        Task mediumTask = new Task("Medium Priority", "Description", TaskPriority.MEDIUM);
        
        int result = comparator.compare(highTask, mediumTask);
        assertTrue(result < 0, "HIGH should come before MEDIUM");
    }
    
    @Test
    void testHighBeforeLow() {
        Descending comparator = new Descending();
        Task highTask = new Task("High Priority", "Description", TaskPriority.HIGH);
        Task lowTask = new Task("Low Priority", "Description", TaskPriority.LOW);
        
        int result = comparator.compare(highTask, lowTask);
        assertTrue(result < 0, "HIGH should come before LOW");
    }
    
    @Test
    void testMediumBeforeLow() {
        Descending comparator = new Descending();
        Task mediumTask = new Task("Medium Priority", "Description", TaskPriority.MEDIUM);
        Task lowTask = new Task("Low Priority", "Description", TaskPriority.LOW);
        
        int result = comparator.compare(mediumTask, lowTask);
        assertTrue(result < 0, "MEDIUM should come before LOW");
    }
    
    @Test
    void testSamePriority() {
        Descending comparator = new Descending();
        Task task1 = new Task("Task 1", "Description", TaskPriority.MEDIUM);
        Task task2 = new Task("Task 2", "Description", TaskPriority.MEDIUM);
        
        int result = comparator.compare(task1, task2);
        assertEquals(0, result, "Tasks with same priority should be equal");
    }
}