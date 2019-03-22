package com.ceiba.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.todo.controllers.dto.AuthDTO;
import com.ceiba.todo.persistence.entity.User;
import com.ceiba.todo.services.security.SecurityService;
import com.ceiba.todo.services.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;

	/**
	 * 
	 * @param user
	 * @return User
	 */
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	

	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public User login(@RequestBody AuthDTO auth) throws Exception {
	if (securityService.authenticate(auth.getUserName(), auth.getPassword())) {
		return userService.findUserByUserName(auth.getUserName());
	}
		throw new Exception("Auth Error");
	}

}
