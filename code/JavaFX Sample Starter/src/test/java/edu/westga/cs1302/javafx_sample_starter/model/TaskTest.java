package edu.westga.cs1302.javafx_sample_starter.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit tests for the Task class.
 * Tests constructor, getter methods, toString method, and validation.
 * 
 * @author [Your Name]
 * @version Fall 2025
 */
public class TaskTest {

    @Test
    public void testConstructorValidInputs() {
        // Test normal constructor with valid inputs
        Task task = new Task("Complete homework", "Finish CS project", "High");
        
        assertEquals("Complete homework", task.getName());
        assertEquals("Finish CS project", task.getDescription());
        assertEquals("High", task.getPriority());
    }
    
    @Test
    public void testGetName() {
        // Test getName returns correct value
        Task task = new Task("Task Name", "Description", "High");
        assertEquals("Task Name", task.getName());
    }
    
    @Test
    public void testGetDescription() {
        // Test getDescription returns correct value
        Task task = new Task("Task Name", "This is the description", "Low");
        assertEquals("This is the description", task.getDescription());
    }
    
    @Test
    public void testGetPriority() {
        // Test getPriority returns correct value
        Task task = new Task("Task Name", "Description", "Medium");
        assertEquals("Medium", task.getPriority());
    }
    
    @Test
    public void testToString() {
        // Test toString returns task name as required
        Task task = new Task("Important Task", "Description", "High");
        assertEquals("Important Task", task.toString());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullName() {
        // Test that null name throws exception
        new Task(null, "Valid description", "Medium");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmptyName() {
        // Test that empty name throws exception
        new Task("", "Valid description", "Medium");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullDescription() {
        // Test that null description throws exception
        new Task("Valid name", null, "Medium");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullPriority() {
        // Test that null priority throws exception
        new Task("Valid name", "Valid description", null);
    }
}