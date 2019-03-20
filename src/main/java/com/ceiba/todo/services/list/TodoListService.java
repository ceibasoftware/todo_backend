package com.ceiba.todo.services.list;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.todo.persistence.dao.TodoListDao;
import com.ceiba.todo.persistence.entity.TodoList;

@Service
public class TodoListService{

	@Autowired
    private TodoListDao todoListDao;

	@Transactional
	public List<TodoList> listsByUserId(Integer userId) {
		return todoListDao.listsByUserId(userId);
	}

	@Transactional
	public Optional<TodoList> listsById(Integer listId) {
		return todoListDao.findById(listId);
	}

	@Transactional
	public TodoList create(TodoList todoList) {
		return todoListDao.save(todoList);
	}

	@Transactional
	public TodoList update(TodoList todoList) {
		return todoListDao.save(todoList);
	}

	@Transactional
	public void delete(TodoList todoList) {
		todoListDao.delete(todoList);
	}

}
