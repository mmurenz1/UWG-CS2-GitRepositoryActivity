package edu.westga.cs1302.task_tracker.model.container_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {

	@Test
	void testNullTask() {
		ContainerTask container = new ContainerTask("name", "desc", TaskPriority.HIGH);
		
		assertThrows(IllegalArgumentException.class, () -> {
			container.addTask(null);
		});
	}
	
	@Test
	void testAddOneTask() {
		ContainerTask container = new ContainerTask("name", "desc", TaskPriority.HIGH);
		Task subtask = new Task("subtask", "desc", TaskPriority.LOW);
		
		Task result = container.addTask(subtask);
		
		assertEquals(container, result);
		assertEquals(1, container.getSubTasks().size());
		assertEquals(subtask, container.getSubTasks().get(0));
	}
	
	@Test
	void testAddMultipleTasks() {
		ContainerTask container = new ContainerTask("name", "desc", TaskPriority.HIGH);
		Task subtask1 = new Task("subtask1", "desc", TaskPriority.LOW);
		Task subtask2 = new Task("subtask2", "desc", TaskPriority.MEDIUM);
		
		container.addTask(subtask1);
		container.addTask(subtask2);
		
		assertEquals(2, container.getSubTasks().size());
		assertEquals(subtask1, container.getSubTasks().get(0));
		assertEquals(subtask2, container.getSubTasks().get(1));
	}
}