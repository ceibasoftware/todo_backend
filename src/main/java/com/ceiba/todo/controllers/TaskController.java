package com.ceiba.todo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.todo.controllers.dto.TaskDTO;
import com.ceiba.todo.persistence.entity.Task;
import com.ceiba.todo.services.task.TaskService;

/**
 * 
 * @author german.arroyave
 *
 */

@RestController
@RequestMapping("/api/todo/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private Mapper mapper;

	/**
	 * 
	 * @param listId
	 * @return List<Task>
	 */
	@RequestMapping(value = "/list/{list_id}", method = RequestMethod.GET)
	public List<TaskDTO> tasksByListId(@PathVariable(value = "list_id") Integer listId) {
		List<Task> listTask = taskService.tasksByListId(listId);
		List<TaskDTO> listDto = new ArrayList<>();
		mapper.map(listTask, listDto);
		return listDto;
	}

	/**
	 * 
	 * @param taskId
	 * @return Optional<Task>
	 */
	@RequestMapping(value = "/{task_id}", method = RequestMethod.GET)
	public Optional<Task> taskById(@PathVariable(value = "task_id") Integer taskId) {
		Optional<Task> listTask = taskService.taskById(taskId);
		Optional<TaskDTO> listDto = Optional.ofNullable(new TaskDTO());
		mapper.map(listTask, listDto);
		return listTask;
	}

	/**
	 * 
	 * @param task
	 * @return Task
	 */
	@RequestMapping(method = RequestMethod.POST)
	public TaskDTO create(@RequestBody TaskDTO taskDto) {
		Task task = new Task();
		mapper.map(taskDto, task);
		return mapper.map(taskService.create(task), TaskDTO.class);
	}

	/**
	 * 
	 * @param task
	 * @return Task
	 */
	@RequestMapping(value = "{task_id}", method = RequestMethod.PUT)
	public TaskDTO update(@RequestBody TaskDTO taskDto) {
		Task task = new Task();
		mapper.map(taskDto, task);
		return mapper.map(taskService.update(task), TaskDTO.class);
	}

	/**
	 * 
	 * @param task
	 */
	@RequestMapping(value = "{task_id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "task_id") Integer taskId) {
		taskService.delete(taskId);
	}
}
