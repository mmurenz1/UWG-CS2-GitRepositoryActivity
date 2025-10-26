package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

/** Represents a Task that can contain subtasks
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class ContainerTask extends Task {
	
	private List<Task> subTasks;
	
	/** Creates a new ContainerTask with the provided information
	 * 
	 * @precondition name != null && !name.isEmpty() &&
	 *               description != null &&
	 *               priority != null
	 * 
	 * @param name the name of the task
	 * @param description the description of the task
	 * @param priority the priority of the task
	 */
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
		this.subTasks = new ArrayList<Task>();
	}
	
	/** Returns the list of subtasks for this container task
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of subtasks
	 */
	@Override
	public List<Task> getSubTasks() {
		return this.subTasks;
	}
	
	/** Adds a subtask to this container task
	 * 
	 * @precondition task != null
	 * @postcondition getSubTasks().size() == getSubTasks().size()@prev + 1
	 * 
	 * @param task the subtask to add
	 * @return this ContainerTask
	 */
	@Override
	public Task addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("task must not be null");
		}
		
		this.subTasks.add(task);
		return this;
	}
	
	/** Returns the name of the task with an indicator that it contains subtasks
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the task with (+) indicator
	 */
	@Override
	public String toString() {
		return this.getName() + " (+)";
	}
}
