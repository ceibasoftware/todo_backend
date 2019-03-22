package com.ceiba.todo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ceiba.todo.persistence.dao.UserDao;
import com.ceiba.todo.persistence.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	public CustomUserDetailsService() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(final String username) {
		final User user = userDao.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserPrincipal(user);
	}

}