package com.boot.blog.domain.model.entity;

public class UserSession {
	String userName;
	String authority;
	
	public UserSession(String userName, String authority) {
		this.userName = userName;
		this.authority = authority;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
	
	
}

