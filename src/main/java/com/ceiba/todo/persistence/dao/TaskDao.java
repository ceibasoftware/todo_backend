package com.ceiba.todo.persistence.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.todo.persistence.entity.Task;
import java.util.List;

@Repository
public interface TaskDao  extends CrudRepository<Task, Integer> {

	@Query("select t.task_id, t.title, t.done, t.category, t.user_id from tasks t where t.user_id = :userId order by t.task_id")
	List<Task> findAllByUserId(@Param("userId") Integer userId);
	
	@Query("select distinct(t.category) from tasks t where t.user_id = :userId order by t.category")
	List<String> listCategoriesByUserId(@Param("userId") Integer userId);
	
	@Query("select t.task_id, t.title, t.done, t.category, t.user_id from tasks t where t.user_id = :userId and t.category = :category order by t.task_id")
	List<Task> listByUserIdAndCategory(@Param("userId") Integer userId, @Param("category") String category);
}
