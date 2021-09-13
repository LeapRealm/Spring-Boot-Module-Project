package com.five.mini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.five.mini.model.UserList;

public interface UserListRepository extends JpaRepository<UserList, Long>{	
	public List<UserList> findByUserEmail(String userEmail);
	public List<UserList> findByUserPassword(String userPassword);
	public UserList findByUserEmailAndUserPassword(String userEmail, String userPassword);
}