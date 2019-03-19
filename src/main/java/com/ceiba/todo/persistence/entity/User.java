package com.ceiba.todo.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

@Table("users")
public class User {
	@Id
    private Integer userId;
	@NonNull
	private String name;
	@NonNull
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
