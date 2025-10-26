package edu.westga.cs1302.task_tracker.model.container_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestToString {

	@Test
	void testToStringIncludesIndicator() {
		ContainerTask container = new ContainerTask("MyTask", "desc", TaskPriority.HIGH);
		
		assertEquals("MyTask (+)", container.toString());
	}
}