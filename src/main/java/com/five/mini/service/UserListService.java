package com.five.mini.service;

import java.util.List;

import com.five.mini.model.UserList;

public interface UserListService {
	public List<UserList> getUserList();
	public List<UserList> getUserEmail(String userEmail);
	public List<UserList> getUserPassword(String userPassword);
	public UserList getUserEmailAndUserPassword(String userEmail, String userPassword);
}