package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	// Temporary master list to hold all tasks while running
	private final Map<String, Task> tasks = new HashMap<>();
	
	// Saves a new task to master list if ID doesn't exist
	public boolean addTask(Task task) {
		if (task == null || tasks.containsKey(task.getTaskId())) {
			//reject adding if task is missing or ID is duplicate
			return false;
		}
		tasks.put(task.getTaskId(), task);
		//confirm adding successfully
		return true;
	}
	
	// Remove from master list using its ID
	public boolean deleteTask(String taskId) {
		if (taskId == null || !tasks.containsKey(taskId)) {
			//reject if ID doesn't exist
			return false;
		}
		tasks.remove(taskId);
		//confirm deleting successfully
		return true;
	}
	
	// Find task by ID and update name
	public boolean updateTaskName(String taskId, String newName) {
		Task task = tasks.get(taskId);
		if (task == null) {
			// Fail if task not found
			return false;
		}
		try {
			// Check if new name follows conditions
			task.setName(newName); 
			// Confirm name change worked
			return true;
		} catch (IllegalArgumentException e) {
			// Reject if does not follow conditions
			return false;
		}
	}
	
	// Find task by ID and update description
	public boolean updateTaskDescription(String taskId, String newDescription) {
		Task task = tasks.get(taskId);
		if (task == null) {
			// Fail if task not found
			return false;
		}
		try {
			// Check if new name follows conditions
			task.setDescription(newDescription); 
			// Confirm description change worked
			return true;
		} catch (IllegalArgumentException e) {
			// Reject if does not follow conditions
			return false;
		}
	}
	
	// A tool to check a task's current information
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
}
