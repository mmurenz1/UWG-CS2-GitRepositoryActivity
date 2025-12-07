package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestGetSubTasks {

	@Test
	void testRegularTaskHasNoSubTasks() {
		Task task = new Task("task", "desc", TaskPriority.HIGH);
		
		assertEquals(0, task.getSubTasks().size());
	}
}