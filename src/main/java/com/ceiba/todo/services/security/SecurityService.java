package com.ceiba.todo.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ceiba.todo.exception.TransactionException;

@Service
public class SecurityService {

	@Autowired
	private DaoAuthenticationProvider authenticationProvider;

	public boolean authenticate(String username, String password) {
		try {
			Authentication newAuthentication = authenticationProvider
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));

			if (newAuthentication != null && newAuthentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(newAuthentication);
				return true;
			}
		} catch (Exception e) {
			throw new TransactionException(e.getMessage());
		}
		return false;
	}
}
