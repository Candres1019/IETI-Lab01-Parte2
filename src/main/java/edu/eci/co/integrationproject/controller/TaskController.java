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

@Log4j2
@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

	private final TaskService taskService;

	@GetMapping
	public ResponseEntity<List<Task>> all() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

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
