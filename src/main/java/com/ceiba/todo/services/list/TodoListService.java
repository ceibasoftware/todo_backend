package com.ceiba.todo.services.list;

import java.util.List;
import java.util.Optional;

import com.ceiba.todo.persistence.entity.TodoList;

public interface TodoListService {

	/**
	 * 
	 * @param userId
	 * @return
	 */
	List<TodoList> listsByUserId(Integer userId);
	
	/**
	 * 
	 * @param listId
	 * @return
	 */
	Optional<TodoList> listsById(Integer listId);
	
	/**
	 * 
	 * @param todoList
	 * @return
	 */
	TodoList create(TodoList todoList);
	
	/**
	 * 
	 * @param todoList
	 * @return
	 */
	TodoList update(TodoList todoList);
	
	/**
	 * 
	 * @param todoList
	 * @return
	 */
	void delete(TodoList todoList);
}
