package com.ceiba.todo.persistence.entity;

import org.springframework.data.annotation.Id;

public class User {
	@Id
    private Integer userId;
	private String name;
    private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
}
