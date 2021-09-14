package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.domain.User;
import com.web.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		User findByEmail = userRepository.findByEmail(user.getEmail());
		if (findByEmail == null)
			return userRepository.save(user);
		else
			return null;
	}

	@Override
	public User findById(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent())
			return user.get();
		else
			return null;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Integer userId, User user) {
		Optional<User> findById = userRepository.findById(userId);
		if (findById.isPresent()) {
			user.setId(findById.get().getId());
			return userRepository.save(user);
		} else
			return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
