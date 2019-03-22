package com.ceiba.todo.persistence.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
	@Query("select t.user_id, t.username, t.password from users t where t.username = :userName")
	User findUserByUsername(@Param("userName") String userName);

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return User
	 */
	@Query("select t.user_id, t.username, t.password from users t where t.username = :userName and t.password = :password")
	User login(@Param("userName") String userName, @Param("password") String password);

}
