package com.ceiba.todo.persistence.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.todo.persistence.entity.User;

/**
 * 
 * @author german.arroyave
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	/**
	 * 
	 * @param userName
	 * @return User
	 */
	@Query("select t.user_id, t.name, t.user_name from users t where t.user_name :userName")
	User findUserByUsername(String userName);
	  
}
