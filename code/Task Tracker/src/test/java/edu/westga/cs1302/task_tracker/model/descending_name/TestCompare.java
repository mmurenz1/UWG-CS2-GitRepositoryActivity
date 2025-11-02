package edu.westga.cs1302.task_tracker.model.descending_name;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

    @Test
    void testO1IsNull() {
        Task o2 = new Task("banana", "desc", TaskPriority.HIGH);
        DescendingName descending = new DescendingName();
        
        assertThrows(IllegalArgumentException.class, ()->{descending.compare(null, o2);});
    }
    
    @Test
    void testO2IsNull() {
        Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
        DescendingName descending = new DescendingName();
        
        assertThrows(IllegalArgumentException.class, ()->{descending.compare(o1, null);});
    }
    
    @Test
    void testO1AppleAndO2Banana() {
        Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
        Task o2 = new Task("banana", "desc", TaskPriority.HIGH);
        DescendingName descending = new DescendingName();
        
        int result = descending.compare(o1, o2);
        
        assertTrue(result > 0);
    }
    
    @Test
    void testO1BananaAndO2Apple() {
        Task o1 = new Task("banana", "desc", TaskPriority.HIGH);
        Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
        DescendingName descending = new DescendingName();
        
        int result = descending.compare(o1, o2);
        
        assertTrue(result < 0);
    }
    
    @Test
    void testO1AppleAndO2Apple() {
        Task o1 = new Task("apple", "desc", TaskPriority.HIGH);
        Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
        DescendingName descending = new DescendingName();
        
        int result = descending.compare(o1, o2);
        
        assertTrue(result == 0);
    }
    
    @Test
    void testO1ZebraAndO2Apple() {
        Task o1 = new Task("zebra", "desc", TaskPriority.LOW);
        Task o2 = new Task("apple", "desc", TaskPriority.HIGH);
        DescendingName descending = new DescendingName();
        
        int result = descending.compare(o1, o2);
        
        assertTrue(result < 0);
    }
    
    @Test
    void testO1AppleAndO2Zebra() {
        Task o1 = new Task("apple", "desc", TaskPriority.LOW);
        Task o2 = new Task("zebra", "desc", TaskPriority.HIGH);
        DescendingName descending = new DescendingName();
        
        int result = descending.compare(o1, o2);
        
        assertTrue(result > 0);
    }
}