package com.ceiba.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.todo.persistence.entity.User;
import com.ceiba.todo.services.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService userService;
	
	/**
	 * 
	 * @param user
	 * @return  User
	 */
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
        return userService.create(user);
    }
	
}
