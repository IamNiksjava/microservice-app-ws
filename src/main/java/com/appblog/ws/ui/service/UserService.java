package com.appblog.ws.ui.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appblog.ws.entity.UserEntity;
import com.appblog.ws.exception.NoRecordFoundException;
import com.appblog.ws.exception.RecordNotFoundException;
import com.appblog.ws.model.RegisterUserRequest;
import com.appblog.ws.repository.SearchRepository;
import com.appblog.ws.shared.Utils;

@Service
public class UserService {

	Map<String, RegisterUserRequest> users;
	Utils utils;

	public UserService() {
	}

	@Autowired
	public UserService(Utils utils) {
		this.utils = utils;
	}

	@Autowired
	private SearchRepository searchRepository;

	public RegisterUserRequest registerUser(RegisterUserRequest userRequest) {

		UserEntity us = new UserEntity();
		us.setFirstname(userRequest.getFirstname());
		us.setLastname(userRequest.getLastname());
		us.setPassword(userRequest.getPassword());
		us.setEmail(userRequest.getEmail());

		String userId = UUID.randomUUID().toString();
		us.setRandomId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, userRequest);
		userRequest.setRandomId(userId);
		searchRepository.save(us);
		return userRequest;

	}

	public RegisterUserRequest getUserBasedonUserId(String randomId) throws RecordNotFoundException {

		List<Object> useridResponse = searchRepository.getUserBasedonUserId(randomId);
		Iterator it = useridResponse.iterator();
		RegisterUserRequest rUserrequest = new RegisterUserRequest();
		while (it.hasNext()) {
			Object[] row = (Object[]) it.next();
			rUserrequest.setEmail(String.valueOf(row[1]));
			rUserrequest.setFirstname(String.valueOf(row[2]));
			rUserrequest.setLastname(String.valueOf(row[3]));
			rUserrequest.setPassword(String.valueOf(row[4]));
			rUserrequest.setRandomId(String.valueOf(row[5]));
		}

		return rUserrequest;
	}

	public RegisterUserRequest updateUser(Integer userid, RegisterUserRequest request) {
		UserEntity us = new UserEntity();
		Object id = searchRepository.findById(userid);
		if (userid == id) {
			us.setEmail(request.getEmail());
			us.setFirstname(request.getFirstname());
			us.setLastname(request.getLastname());
			us.setPassword(request.getPassword());
			searchRepository.save(us);
		}
		return request;
	}

	public RegisterUserRequest updateUser(RegisterUserRequest userRequest) {
		UserEntity existCust = searchRepository.findById(userRequest.getUserid()).orElse(null);
		existCust.setEmail(userRequest.getEmail());
		existCust.setFirstname(userRequest.getFirstname());
		existCust.setLastname(userRequest.getLastname());
		existCust.setPassword(userRequest.getPassword());
		searchRepository.save(existCust);
		return userRequest;
	}

	public String deleteUser(Integer userid) {
		searchRepository.deleteById(userid);
		return "user deleted by ID"+ userid;
	}

	
}
