package com.ceiba.todo.persistence.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.todo.persistence.entity.TodoList;

/**
 * 
 * @author german.arroyave
 *
 */

@Repository
public interface TodoListDao extends CrudRepository<TodoList, Integer> {

	/**
	 * 
	 * @param userId
	 * @return List<String>
	 */
	@Query("select t.list_id, t.user_id, t.name, t.description from lists t where t.user_id = :userId order by t.list_id")
	List<TodoList> listsByUserId(@Param("userId") Integer userId);
	
}
