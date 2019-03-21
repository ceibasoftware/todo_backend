package com.ceiba.todo.services.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ceiba.todo.persistence.dao.TaskDao;
import com.ceiba.todo.persistence.entity.Task;

@Service
public class TaskService {

	@Autowired
    private TaskDao taskDao;
	
	@Transactional
	public Task create(Task task) {
		taskDao.save(task);
		return task;
	}

	@Transactional
	public Task update(Task task) {
		return taskDao.save(task);
	}

	@Transactional
	public void delete(Integer taskId) {
		taskDao.deleteById(taskId);
	}

	@Transactional
	public List<Task> tasksByListId(Integer listId) {
		return taskDao.tasksByListId(listId);
	}

	@Transactional
	public Optional<Task> taskById(Integer taskId) {
		return taskDao.findById(taskId);
	}

	
}
