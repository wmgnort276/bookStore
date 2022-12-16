package com.example.demo.securityTest.payload.response;

import lombok.Data;

@Data
public class UserInfoResponse {
	private String username;
	private String email;
	private String role;

	public UserInfoResponse(String username, String email, String role) {
		this.username = username;
		this.email = email;
		this.role = role;
	}

}
