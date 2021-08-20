package edu.eci.co.integrationproject.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import edu.eci.co.integrationproject.data.Task;
import edu.eci.co.integrationproject.exception.TaskServiceException;
import edu.eci.co.integrationproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Define the signature to implement a Task Service
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@RequiredArgsConstructor
public class TaskServiceHashMap implements TaskService {

	/**
	 * The AtomicInteger to be used to assign a new id
	 */
	private static final AtomicInteger taskIdCounter = new AtomicInteger(1);

	/**
	 * The HashMap were the Task are saved
	 */
	private final HashMap<String, Task> taskHashMap;

	/**
	 * {@inheritDoc}
	 */
	@Override public Task create(final Task task) {

		task.setId(String.valueOf(taskIdCounter.getAndIncrement()));
		taskHashMap.put(task.getId(), task);
		return task;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Task findById(final String id) throws TaskServiceException {

		if (taskHashMap.containsKey(id)) {
			return taskHashMap.get(id);
		}
		throw new TaskServiceException(TaskServiceException.TASK_NOT_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public List<Task> all() {

		return new ArrayList<>(taskHashMap.values());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public void deleteById(final String id) {

		taskHashMap.remove(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public Task update(final Task task, final String id) {

		task.setId(id);
		taskHashMap.put(id, task);
		return task;
	}
}
