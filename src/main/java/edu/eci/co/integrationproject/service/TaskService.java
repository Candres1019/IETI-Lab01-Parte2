package edu.eci.co.integrationproject.service;

import java.util.List;

import edu.eci.co.integrationproject.data.Task;
import edu.eci.co.integrationproject.exception.TaskServiceException;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {

	Task create(Task task);

	Task findById(String id) throws TaskServiceException;

	List<Task> all();

	void deleteById(String id);

	Task update(Task task, String id);

}
