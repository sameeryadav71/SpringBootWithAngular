package com.web.service;

import java.util.List;

import com.web.domain.User;

public interface UserService {

	User addUser(User user);
	User findById(Integer userId);
	List<User> findAllUsers();
	User updateUser(Integer userId, User user);
	void deleteUser(Integer userId);
	User findByEmail(String email);
}
