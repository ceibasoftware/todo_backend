package com.ceiba.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private TaskService  taskService;
	
	@RequestMapping(value = "/list/{list_id}", method = RequestMethod.GET)
    public List<Task> tasksByListId(@PathVariable(value = "list_id") Integer listId)
    {
        return taskService.tasksByListId(listId);
    }
	
	@RequestMapping(value = "/{task_id}", method = RequestMethod.GET)
    public Optional<Task> taskById(@PathVariable(value = "task_id") Integer taskId)
    {
        return taskService.taskById(taskId);
    }
	
	/**
	 * 
	 * @param task
	 * @return Task
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }
	
	/**
	 * 
	 * @param task
	 * @return Task
	 */
	@RequestMapping(value = "{task_id}", method = RequestMethod.PUT)
	public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }
	
	/**
	 * 
	 * @param task
	 */
	@RequestMapping(value = "{task_id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Task task) {
        taskService.delete(task);
    }
}
