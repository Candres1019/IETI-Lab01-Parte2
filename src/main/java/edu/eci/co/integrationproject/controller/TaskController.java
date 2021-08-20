package edu.eci.co.integrationproject.controller;

import java.util.List;

import edu.eci.co.integrationproject.data.Task;
import edu.eci.co.integrationproject.dto.TaskDto;
import edu.eci.co.integrationproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller of the endpoint for the task
 *
 * @author Andres Calderon (andres.calderon@escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Log4j2
@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

	/**
	 * The task service
	 */
	private final TaskService taskService;

	/**
	 * Get All endpoint
	 *
	 * @return List of the {@link Task} saved in the server
	 */
	@GetMapping
	public ResponseEntity<List<Task>> all() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Get findById endpoint
	 *
	 * @param id The id of the {@link Task} to be found
	 * @return The {@link Task} found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Post create endpoint
	 *
	 * @param taskDto The {@link TaskDto} to be saved
	 * @return The {@link Task} saved in the server
	 */
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody TaskDto taskDto) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(taskService.create(new ModelMapper().map(taskDto, Task.class)));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Put update endpoint
	 *
	 * @param taskDto The {@link TaskDto} to be updated
	 * @param id      The {@link Task} id to be updated
	 * @return The {@link Task} after being updated
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@RequestBody TaskDto taskDto, @PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK)
								 .body(taskService.update(new ModelMapper().map(taskDto, Task.class), id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/**
	 * Delete delete endpoint
	 *
	 * @param id The {@link Task} id to be deleted
	 * @return If the Task has been deleted
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {

		try {
			taskService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
		}
	}

}
