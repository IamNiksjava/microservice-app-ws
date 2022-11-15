package com.appblog.ws.model;

import lombok.Data;

@Data
public class RegisterUserRequest {
	private Integer userid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String randomId;

}
