package com.ceiba.todo.services.user;

import com.ceiba.todo.persistence.entity.User;

/**
 * 
 * @author german.arroyave
 *
 */
public interface UserService {

	/**
	 * 
	 * @param userName
	 * @return User
	 */
	User findUserByUserName(String userName);

	/**
	 * 
	 * @param user
	 * @return User
	 */
	User create(User user);

}
