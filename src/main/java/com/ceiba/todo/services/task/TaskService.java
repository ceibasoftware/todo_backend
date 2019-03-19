package com.ceiba.todo.services.task;

import java.util.List;
import java.util.Optional;

import com.ceiba.todo.persistence.entity.Task;

/**
 * 
 * @author german.arroyave
 *
 */
public interface TaskService {
	/**
	 * 
	 * @param task
	 * @return
	 */
	Task create(Task task);
	
	/**
	 * 
	 * @param task
	 * @return
	 */
	Task update(Task task);
	
	/**
	 * 
	 * @param taskId
	 */
	void delete(Task task);

	List<Task> tasksByListId(Integer listId);

	Optional<Task> taskById(Integer taskId);

}
