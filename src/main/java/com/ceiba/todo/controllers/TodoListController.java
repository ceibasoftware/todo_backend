package com.ceiba.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.todo.persistence.entity.TodoList;
import com.ceiba.todo.services.list.TodoListService;

/**
 * 
 * @author german.arroyave
 *
 */

@RestController
@RequestMapping("/api/todo/list")
public class TodoListController {

	@Autowired
    private TodoListService  todoListService;

	/**
	 * 
	 * @param userId
	 * @return List<TodoList>
	 */
	@RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public List<TodoList> listsByUserId(@PathVariable(value = "user_id") Integer userId)
    {
        return todoListService.listsByUserId(userId);
    }
	
	/**
	 * 
	 * @param listId
	 * @return
	 */
	@RequestMapping(value = "/{list_id}", method = RequestMethod.GET)
    public Optional<TodoList> listsById(@PathVariable(value = "list_id") Integer listId)
    {
        return todoListService.listsById(listId);
    }
	
	/**
	 * 
	 * @param todoList
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public TodoList create(@RequestBody TodoList todoList) {
        return todoListService.create(todoList);
    }
	
	/**
	 * 
	 * @param todoList
	 * @return
	 */
	@RequestMapping(value = "/{list_id}", method = RequestMethod.PUT)
	public TodoList update(@RequestBody TodoList todoList) {
        return todoListService.update(todoList);
    }
	
	/**
	 * 
	 * @param todoList
	 */
	@RequestMapping(value = "/{list_id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody TodoList todoList) {
		todoListService.delete(todoList);
    }
}
