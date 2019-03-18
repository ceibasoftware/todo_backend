package com.ceiba.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.todo.persistence.entity.Task;
import com.ceiba.todo.services.task.TaskService;

@RestController
@RequestMapping("/tasks")
public class TodoController {

	@Autowired
    private TaskService  taskService;
	
	@RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public List<Task> findByUserId(@PathVariable(value = "user_id") Integer userId)
    {
        return taskService.findByUserId(userId);
    }
	
	@RequestMapping(value = "categories/user/{user_id}", method = RequestMethod.GET)
    public List<String> listCategoriesByUserId(@PathVariable(value = "user_id") Integer userId)
    {
        return taskService.listCategoriesByUserId(userId);
    }
	
	@RequestMapping(value = "/user/{user_id}/category/{category}", method = RequestMethod.GET)
    public List<Task> listByUserIdAndCategory(@PathVariable(value = "user_id") Integer userId,
    										  @PathVariable(value = "category") String category)
    {
        return taskService.listByUserIdAndCategory(userId, category);
    }
	
	
}
