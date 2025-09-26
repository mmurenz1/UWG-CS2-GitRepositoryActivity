package edu.westga.cs1302.javafx_sample_starter.model;

import java.util.List;

/**
 * Utility class for operations related to tasks.
 * 
 * @author MickelMurenzi
 * @version Fall 2025
 */
public class TaskUtility {
	
	/**
	 * Counts the number of tasks with the specified priority
	 * 
	 * @param priority the priority to count
	 * @param tasks the list of the tasks to search
	 * @return the number of tasks with the specified priority
	 */
	public static int countTasksByPriority(String priority, List<Task> tasks) {
		if  (priority == null || tasks == null) {
			return 0;
		}
		
		int count = 0;
		for (Task task : tasks) {
			if (priority.equals(task.getPriority())) {
				count++;
			}
		}
		return count;
	}

}
