package com.ceiba.todo.persistence.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.todo.persistence.entity.Task;
import java.util.List;

/**
 * 
 * @author german.arroyave
 *
 */

@Repository
public interface TaskDao  extends CrudRepository<Task, Integer> {
	
	@Query("select t.task_id, t.title, t.done, t.list_id from tasks t where t.list_id = :listId order by t.list_id")
	List<Task> tasksByListId(Integer listId);

}
