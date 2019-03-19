package com.ceiba.todo.persistence.dao;

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
	User findUserByUsername(String userName);
}
