package com.appblog.ws.ui.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appblog.ws.entity.UserEntity;
import com.appblog.ws.errorcodes.ErrorCodes;
import com.appblog.ws.exception.InsertionFailed;
import com.appblog.ws.exception.RecordNotFoundException;
import com.appblog.ws.model.RegisterUserRequest;
import com.appblog.ws.repository.SearchRepository;
import com.appblog.ws.ui.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private SearchRepository searchRepository;
	
	@Autowired
	private UserService userService;

	Map<String, UserEntity> users;

	@PostMapping("/registerUser")
	public ResponseEntity<RegisterUserRequest> registerUser(@RequestBody RegisterUserRequest userRequest)
			throws RecordNotFoundException {

		RegisterUserRequest updated = userService.registerUser(userRequest);

		if (updated == null) {
			InsertionFailed insertionFailed = new InsertionFailed(ErrorCodes.insertionFailed,
					"insert/update failed for", "User");
			throw insertionFailed;
		}
		return new ResponseEntity<RegisterUserRequest>(updated, new HttpHeaders(), HttpStatus.CREATED);
	}

	@GetMapping("/getUser/{randomId}")
	public ResponseEntity<RegisterUserRequest> getUserBasedonUserId(@PathVariable String randomId)
			throws RecordNotFoundException {

		RegisterUserRequest basedUserResp = userService.getUserBasedonUserId(randomId);
		if (basedUserResp == null) {
			RecordNotFoundException recordNotFoundException = new RecordNotFoundException(ErrorCodes.idNotFound,
					"users");
			throw recordNotFoundException;
		}

		return new ResponseEntity<RegisterUserRequest>(basedUserResp, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	@PutMapping("/update")
	public RegisterUserRequest updateUser(@RequestBody RegisterUserRequest userRequest) {
		
		
		return userService.updateUser(userRequest);
	}
	
	
	
	@DeleteMapping("/delete/{userid}")
	public String deleteUser(@PathVariable Integer userid) {
		
		
		return userService.deleteUser(userid);
	}
	

}