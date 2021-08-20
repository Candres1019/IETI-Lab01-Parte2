package edu.eci.co.integrationproject.data;

import java.util.Date;

import edu.eci.co.integrationproject.share.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Task class
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	/**
	 * The task identifier
	 */
	private String id;

	/**
	 * The task name
	 */
	private String name;

	/**
	 * The task description
	 */
	private String description;

	/**
	 * The status of the task
	 */
	private Status status;

	/**
	 * The person assigned to the task
	 */
	private String assignedTo;

	/**
	 * The Due date of the task
	 */
	private Date dueDate;

	/**
	 * The date of creation of the task
	 */
	private Date createdAt;

}
