package edu.eci.co.integrationproject.exception;

public class TaskServiceException extends Exception {

	public static final String TASK_NOT_FOUND = "Task not found";

	public TaskServiceException(final String message) {

		super(message);
	}

}
