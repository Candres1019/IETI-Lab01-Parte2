package edu.eci.co.integrationproject.exception;

/**
 * The exception to be thrown when an error is present in the TaskService
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
public class TaskServiceException extends Exception {

	/**
	 * Task Not Found Message
	 */
	public static final String TASK_NOT_FOUND = "Task not found";

	/**
	 * Constructor
	 *
	 * @param message Message of the Exception
	 */
	public TaskServiceException(final String message) {

		super(message);
	}

}
