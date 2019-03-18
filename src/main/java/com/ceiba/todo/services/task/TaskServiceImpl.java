package com.ceiba.todo.services.task;

import java.util.List;

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
    public List<Task> findByUserId(Integer userId)
    {
        return taskDao.findAllByUserId(userId);
    }

	@Override
	@Transactional
	public List<String> listCategoriesByUserId(Integer userId) {
		 return taskDao.listCategoriesByUserId(userId);
	}

	@Override
	@Transactional
	public List<Task> listByUserIdAndCategory(Integer userId, String category) {
		 return taskDao.listByUserIdAndCategory(userId, category);
	}
	
}
