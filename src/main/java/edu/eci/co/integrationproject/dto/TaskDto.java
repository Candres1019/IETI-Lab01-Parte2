package edu.eci.co.integrationproject.dto;

import java.util.Date;

import edu.eci.co.integrationproject.share.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Mapping class for the Task class
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public class TaskDto {

	/**
	 * The task name
	 */
	private final String name;

	/**
	 * The task description
	 */
	private final String description;

	/**
	 * The status of the task
	 */
	private final Status status;

	/**
	 * The person assigned to the task
	 */
	private final String assignedTo;

	/**
	 * The Due date of the task
	 */
	private final Date dueDate;

	/**
	 * The date of creation of the task
	 */
	private final Date createdAt;

}
