package com.ceiba.todo.persistence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.todo.persistence.entity.Task;
import com.ceiba.todo.persistence.entity.User;

import java.util.List;

@Repository
public interface TaskDao  extends CrudRepository<Task, Integer> {

	List<Task> findAllByUser(User user);
}
