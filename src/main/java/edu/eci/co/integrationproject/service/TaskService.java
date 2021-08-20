package edu.eci.co.integrationproject.service;

import java.util.List;

import edu.eci.co.integrationproject.data.Task;
import edu.eci.co.integrationproject.exception.TaskServiceException;
import org.springframework.stereotype.Service;

/**
 * Define the signature to implement a Task Service
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public interface TaskService {

	/**
	 * Create a Task
	 *
	 * @param task The {@link Task} to be created in the records
	 * @return The task that is now in the records
	 */
	Task create(Task task);

	/**
	 * Find a Task that is in the records
	 *
	 * @param id The task id to be found
	 * @return The Task that has been found
	 * @throws TaskServiceException The {@link TaskServiceException}
	 */
	Task findById(String id) throws TaskServiceException;

	/**
	 * Find all the task in the records
	 *
	 * @return All the Task in the records
	 */
	List<Task> all();

	/**
	 * Delete a task given the Task Id
	 *
	 * @param id The id of the task to be deleted
	 */
	void deleteById(String id);

	/**
	 * Update a task if given the Task id
	 *
	 * @param task The {@link Task} with the new information
	 * @param id   The id of the task to be Updated
	 * @return The Task that has been Updated
	 */
	Task update(Task task, String id);

}
