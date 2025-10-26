package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {

	@Test
	void testTaskIsNull() {
		Task task1 = new Task("task1", "desc", TaskPriority.HIGH);
		
		assertThrows(IllegalArgumentException.class, () -> {
			task1.addTask(null);
		});
	}
	
	@Test
	void testAddOneSubTask() {
		Task task1 = new Task("task1", "desc", TaskPriority.HIGH);
		Task task2 = new Task("task2", "desc", TaskPriority.LOW);
		
		Task result = task1.addTask(task2);
		
		assertTrue(result instanceof ContainerTask);
		assertEquals(1, result.getSubTasks().size());
		assertEquals(task2, result.getSubTasks().get(0));
	}
}
