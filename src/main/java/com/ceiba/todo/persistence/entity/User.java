package com.ceiba.todo.persistence.entity;

import org.springframework.data.annotation.Id;

public class User {
	@Id
    private Integer userId;
	private String name;
    private String userNsame;

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

	public String getUserNsame() {
		return userNsame;
	}

	public void setUserNsame(String userNsame) {
		this.userNsame = userNsame;
	}
    
}
