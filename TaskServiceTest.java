package taskTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

public class TaskServiceTest {
	private TaskService service;
	
	// Empties master list before each test
	@BeforeEach
	public void setup() {
		service = new TaskService();
	}
	
	// Confirm that a valid new task is successfully saved
	@Test
	public void testAddTaskSuccess() {
		Task task = new Task("1", "Name", "Description");
		assertTrue(service.addTask(task));
		assertEquals(task, service.getTask("1"));
	}
	
	// Confirm prevents duplicate task IDs
	@Test
	public void testAddDuplicateTestIdFails() {
		Task task1 = new Task("1", "Name", "Description");
		Task task2 = new Task("1", "Name2", "Description2");
		assertTrue(service.addTask(task1));
		assertFalse(service.addTask(task2)); // expected to fail
	}
	
	// Confirm task can be removed successfully
	@Test
	public void testDeleteTaskSuccess() {
		Task task = new Task("1", "Name", "Description");
		service.addTask(task);
		assertTrue(service.deleteTask("1"));
		assertNull(service.getTask("1")); // expected to not be found
	}
	
	// Confirm gives fail notice if trying to delete an ID that doesn't exist
	@Test
	public void testDeleteNonExistentTaskFails() {
		assertFalse(service.deleteTask("999"));
	}
	
	// Confirm can change a task's name
	@Test
	public void testUpdateTaskNameSuccess() {
		Task task = new Task("1", "Old Name", "Description");
		service.addTask(task);
		assertTrue(service.updateTaskName("1", "New Name"));
		assertEquals("New Name", service.getTask("1").getName());
	}
	
	// Confirm can change a task's description
	@Test
	public void testUpdateTaskDescriptionSuccess() {
		Task task = new Task("1", "Name", "Old Description");
		service.addTask(task);
		assertTrue(service.updateTaskDescription("1", "New Description"));
		assertEquals("New Description", service.getTask("1").getDescription());
	}
	
	// Confirms cannot update with bad data
	@Test
	public void testUpdateTaskWithInvalidDataFails() {
		Task task = new Task("1", "Name", "Description");
		service.addTask(task);
		// Tries with a name over 20 characters
		assertFalse(service.updateTaskName("1", "This name is way too long for the limit"));
		//Tries with a blank description
		assertFalse(service.updateTaskDescription("1", null));
	}
}
