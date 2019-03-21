package com.ceiba.todo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.todo.controllers.dto.TodoListDTO;
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

	Mapper mapper = new DozerBeanMapper();
	
	/**
	 * 
	 * @param userId
	 * @return List<TodoList>
	 */
	@RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public List<TodoListDTO> listsByUserId(@PathVariable(value = "user_id") Integer userId)
    {
		List<TodoList> listTodoList = todoListService.listsByUserId(userId);
		List<TodoListDTO> listTodoListDTO = new ArrayList<>(); 
		mapper.map(listTodoList, listTodoListDTO);
        return listTodoListDTO;
    }
	
	/**
	 * 
	 * @param listId
	 * @return
	 */
	@RequestMapping(value = "/{list_id}", method = RequestMethod.GET)
    public Optional<TodoList> listsById(@PathVariable(value = "list_id") Integer listId)
    {
		Optional<TodoList> listTodoList = todoListService.listsById(listId);
		Optional<TodoListDTO> listTodoListDTO = Optional.ofNullable(new TodoListDTO()); 
		mapper.map(listTodoList, listTodoListDTO);
        return listTodoList;
    }
	
	/**
	 * 
	 * @param todoList
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public TodoListDTO create(@RequestBody TodoListDTO todoListDto) {
		TodoList todoList = new TodoList(); 
		mapper.map(todoListDto, todoList);
	    return mapper.map(todoListService.create(todoList), TodoListDTO.class);
    }
	
	/**
	 * 
	 * @param todoList
	 * @return
	 */
	@RequestMapping(value = "/{list_id}", method = RequestMethod.PUT)
	public TodoListDTO update(@RequestBody TodoListDTO todoListDto) {
		TodoList todoList = new TodoList(); 
		mapper.map(todoListDto, todoList);
	    return mapper.map(todoListService.update(todoList), TodoListDTO.class);
    }
	
	/**
	 * 
	 * @param todoList
	 */
	@RequestMapping(value = "/{list_id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "list_id") Integer listId) {
		todoListService.delete(listId);
    }
}
