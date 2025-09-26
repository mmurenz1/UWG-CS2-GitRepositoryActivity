package edu.westga.cs1302.javafx_sample_starter.model;

/**
 * Represents a task with a name, description, and priority.
 * The name and priority are immutable after creation.
 * 
 * @author MickelMurenzi
 * @version Fall 2025
 */
public class Task {
    
    private final String name;        
    private String description;       
    private final String priority;    
    
    /**
     * Creates a new Task with the specified name, description, and priority.
     * 
     * @param name the name of the task (cannot be null or empty)
     * @param description the description of the task (cannot be null)
     * @param priority the priority of the task (cannot be null or empty)
     * @throws IllegalArgumentException if name, description, or priority is null,
     *                                  or if name or priority is empty
     */
    public Task(String name, String description, String priority) {
        if (name == null) {
            throw new IllegalArgumentException("Task name cannot be null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        if (description == null) {
            throw new IllegalArgumentException("Task description cannot be null");
        }
        if (priority == null) {
            throw new IllegalArgumentException("Task priority cannot be null");
        }
        if (priority.trim().isEmpty()) {
            throw new IllegalArgumentException("Task priority cannot be empty");
        }
        
        this.name = name.trim();
        this.description = description;
        this.priority = priority.trim();
    }
    
    /**
     * Gets the name of the task.
     * 
     * @return the task name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the description of the task.
     * 
     * @return the task description
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Gets the priority of the task.
     * 
     * @return the task priority
     */
    public String getPriority() {
        return this.priority;
    }
    
    /**
     * Sets the description of the task.
     * 
     * @param description the new description (cannot be null)
     */
    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Task description cannot be null");
        }
        this.description = description;
    }
    
    /**
     * Returns the name of the task.
     * 
     * @return the task name
     */
    @Override
    public String toString() {
        return this.name;
    }
}