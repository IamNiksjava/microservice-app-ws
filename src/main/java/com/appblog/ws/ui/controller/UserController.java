package com.appblog.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue = "1") int page,
			@RequestParam(value="limit",defaultValue ="50") int limit,
			@RequestParam(value="sort",defaultValue ="desc",required=false)String sort) {
		return "get users was called page ="+page+"and limit ="+limit +" Sort = "+sort;
	}
	
	
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable String userId) {
		return "get user was called ="+ userId;
	}

	@PostMapping
	public String createUser() {
		return "create user was called";
	}
	
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
	
	
}
