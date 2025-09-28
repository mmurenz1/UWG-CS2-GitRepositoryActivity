package edu.westga.cs1302.javafx_sample_starter.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TaskUtilityTest {
	@Test
    public void testCountTasksByPriorityWithValidTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task1", "Description1", "High"));
        tasks.add(new Task("Task2", "Description2", "Medium"));
        tasks.add(new Task("Task3", "Description3", "High"));
        tasks.add(new Task("Task4", "Description4", "Low"));
        
        assertEquals(2, TaskUtility.countTasksByPriority("High", tasks));
        assertEquals(1, TaskUtility.countTasksByPriority("Medium", tasks));
        assertEquals(1, TaskUtility.countTasksByPriority("Low", tasks));
    }
    
    @Test
    public void testCountTasksByPriorityEmptyList() {
        List<Task> tasks = new ArrayList<>();
        assertEquals(0, TaskUtility.countTasksByPriority("High", tasks));
    }
    
    @Test
    public void testCountTasksByPriorityNullList() {
        assertEquals(0, TaskUtility.countTasksByPriority("High", null));
    }
    
    @Test
    public void testCountTasksByPriorityNullPriority() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task1", "Description1", "High"));
        assertEquals(0, TaskUtility.countTasksByPriority(null, tasks));
    }
    
    @Test
    public void testCountTasksByPriorityNonexistentPriority() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task1", "Description1", "High"));
        assertEquals(0, TaskUtility.countTasksByPriority("Critical", tasks));
    }
}

