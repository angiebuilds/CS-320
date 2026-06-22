package taskTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import task.Task;

public class TaskTest {
	
	// Verifies that a task can be created successfully
	@Test
	public void testTaskCreationSuccess() {
		Task task = new Task("12345", "Task Name", "This is a brief description.");
		assertEquals("12345", task.getTaskId());
		assertEquals("Task Name", task.getName());
		assertEquals("This is a brief description.", task.getDescription());
	}
	
	// Confirm blocking a task ID with over 10 characters
	@Test
	public void testTaskIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Task Name", "Description");
		});
	}
	
	// Confirm blocking task if ID is blank
	@Test
	public void testTaskIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task Name", "Description");
		});
	}
	
	// Confirm blocking task if name is over 20 characters
	@Test
	public void testTaskNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "This name is way too long for the limit", "Description");
		});
	}

	// Confirm blocking task if name is blank
	@Test
	public void testTaskNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", null, "Description");
		});
	}
	
	// Confirm blocking task if description is over 50 characters
	@Test
	public void testTaskDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task Name", "This description string is intentionally made to be exceptionally long to trigger validation errors.");
		});
	}
	
	// Confirm blocking task if description is blank
	@Test
	public void testTaskDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task Name", null);
		});
	}
}
