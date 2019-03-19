package com.ceiba.todo.services.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ceiba.todo.persistence.dao.TaskDao;
import com.ceiba.todo.persistence.entity.Task;

@Service
public class TaskServiceImpl  implements TaskService {

	@Autowired
    private TaskDao taskDao;
	
	@Override
	@Transactional
	public Task create(Task task) {
		taskDao.save(task);
		return task;
	}

	@Override
	@Transactional
	public Task update(Task task) {
		return taskDao.save(task);
	}

	@Override
	@Transactional
	public void delete(Task task) {
		taskDao.delete(task);
	}

	@Override
	@Transactional
	public List<Task> tasksByListId(Integer listId) {
		return taskDao.tasksByListId(listId);
	}

	@Override
	public Optional<Task> taskById(Integer taskId) {
		return taskDao.findById(taskId);
	}

	
}
