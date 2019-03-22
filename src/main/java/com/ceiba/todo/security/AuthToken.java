package com.ceiba.todo.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthToken implements Authentication {

	private static final long serialVersionUID = 1849278669542713666L;

	private boolean authenticated = false;

	private String name;

	private final Object principal;

	private Object details;

	private Object credentials;

	private final Collection<GrantedAuthority> authorities;

	public AuthToken(Object principal, Object credentials) {
		this.principal = principal;
		this.credentials = credentials;
		this.authorities = AuthorityUtils.NO_AUTHORITIES;
		setAuthenticated(false);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getDetails() {
		return details;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated = isAuthenticated;
	}

}
