package com.five.mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.five.mini.model.UserList;
import com.five.mini.repository.UserListRepository;

@Service
public class UserListServiceImpl implements UserListService {

	@Autowired
	UserListRepository userListRepository;
	
	@Override
	public List<UserList> getUserList() {
		return userListRepository.findAll();
	}

	@Override
	public List<UserList> getUserEmail(String userEmail) {
		return userListRepository.findByUserEmail(userEmail);
	}

	@Override
	public List<UserList> getUserPassword(String userPassword) {
		return userListRepository.findByUserPassword(userPassword);
	}

	@Override
	public UserList getUserEmailAndUserPassword(String userEmail, String userPassword) {
		return userListRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
	}

}