package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.domain.User;
import com.web.service.UserService;

/**
 * 
 * @author s.yadav
 *
 */
@RestController
@CrossOrigin
@RequestMapping("user/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("findById/{userId}")
	public User findById(@PathVariable("userId")Integer userId) {
		return userService.findById(userId);
	}
	
	@GetMapping("findAllUsers")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@PutMapping("updateUser/{userId}")
	public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
		return userService.updateUser(userId, user);
	}

	@DeleteMapping("deleteUser/{userId}")
	public void deleteUser(@PathVariable("userId")Integer userId) {
		userService.deleteUser(userId);;
	}

	@GetMapping("findByEmail/{email}")
	public User findByEmail(@PathVariable("email")String email) {
		return userService.findByEmail(email);
	}
}
