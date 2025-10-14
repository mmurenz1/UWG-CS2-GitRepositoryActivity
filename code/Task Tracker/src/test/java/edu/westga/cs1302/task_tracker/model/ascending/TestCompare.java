package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Ascending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

    @Test
    void testLowBeforeMedium() {
        Ascending comparator = new Ascending();
        Task lowTask = new Task("Low Priority", "Description", TaskPriority.LOW);
        Task mediumTask = new Task("Medium Priority", "Description", TaskPriority.MEDIUM);
        
        int result = comparator.compare(lowTask, mediumTask);
        assertTrue(result < 0, "LOW should come before MEDIUM");
    }
    
    @Test
    void testLowBeforeHigh() {
        Ascending comparator = new Ascending();
        Task lowTask = new Task("Low Priority", "Description", TaskPriority.LOW);
        Task highTask = new Task("High Priority", "Description", TaskPriority.HIGH);
        
        int result = comparator.compare(lowTask, highTask);
        assertTrue(result < 0, "LOW should come before HIGH");
    }
    
    @Test
    void testMediumBeforeHigh() {
        Ascending comparator = new Ascending();
        Task mediumTask = new Task("Medium Priority", "Description", TaskPriority.MEDIUM);
        Task highTask = new Task("High Priority", "Description", TaskPriority.HIGH);
        
        int result = comparator.compare(mediumTask, highTask);
        assertTrue(result < 0, "MEDIUM should come before HIGH");
    }
    
    @Test
    void testSamePriority() {
        Ascending comparator = new Ascending();
        Task task1 = new Task("Task 1", "Description", TaskPriority.MEDIUM);
        Task task2 = new Task("Task 2", "Description", TaskPriority.MEDIUM);
        
        int result = comparator.compare(task1, task2);
        assertEquals(0, result, "Tasks with same priority should be equal");
    }
}