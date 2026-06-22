package task;

public class Task {
	// Fields are final or private to enforce encapsulation and structure
	private final String taskId;
	private String name;
	private String description;
	
	// Constructor checks all assignment tasks immediately as tasks are made
	public Task(String taskId, String name, String description) {
		// Requirement: ID cannot be empty or more than 10 chars
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID: Must not be null and max 10 characters.");
		}
		// Requirement: Name cannot be empty or more than 20 chars
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name: Must not be null and max 20 characters.");
		}
		// Requirement: Description cannot be empty or more than 50 chars
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description: Must not be null and max 50 characters.");
		}
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	// Allow system to view taskID, but not change it
	public String getTaskId() {
		return taskId;
	}
	
	// Allow system to view task name
	public String getName() {
		return name;
	}
	
	// Allow system to view description
	public String getDescription() {
		return description;
	}
	
	// Allow changing the name so long as follows condition
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name: Must not be null and max 20 characters.");
		}
		this.name = name;
	}
	
	// Allow changing the description so long as follows condition
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description: Must not be null and max 50 characters.");
		}
		this.description = description;
	}
}
