package com.ceiba.todo.services.task;

import java.util.List;

import com.ceiba.todo.persistence.entity.Task;


public interface TaskService {

	List<Task> findByUserId(Integer userId);
	
	List<String> listCategoriesByUserId(Integer userId);

	List<Task> listByUserIdAndCategory(Integer userId, String category);
}
