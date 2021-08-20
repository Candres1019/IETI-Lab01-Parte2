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

@Component
@RequiredArgsConstructor
public class TaskServiceHashMap implements TaskService {

	private static final AtomicInteger taskIdCounter = new AtomicInteger(1);

	private final HashMap<String, Task> taskHashMap;

	@Override public Task create(final Task task) {

		task.setId(String.valueOf(taskIdCounter.getAndIncrement()));
		taskHashMap.put(task.getId(), task);
		return task;
	}

	@Override public Task findById(final String id) throws TaskServiceException {

		if (taskHashMap.containsKey(id)) {
			return taskHashMap.get(id);
		}
		throw new TaskServiceException(TaskServiceException.TASK_NOT_FOUND);
	}

	@Override public List<Task> all() {

		return new ArrayList<>(taskHashMap.values());
	}

	@Override public void deleteById(final String id) {

		taskHashMap.remove(id);
	}

	@Override public Task update(final Task task, final String id) {

		task.setId(id);
		taskHashMap.put(id, task);
		return task;
	}
}
