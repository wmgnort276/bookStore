package com.example.demo.securityTest.payload.response;

import lombok.Data;

@Data
public class UserInfoResponse {
	private Integer id;
	private String username;
	private String email;
	private String role;

	public UserInfoResponse(Integer id, String username, String email, String roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
	}

}
