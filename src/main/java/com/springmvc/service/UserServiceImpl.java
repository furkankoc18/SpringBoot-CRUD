package com.springmvc.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.model.User;
import com.springmvc.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void removeUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User getUserByUuid(String uuid) {
		return userRepository.findUserByUuid(UUID.fromString(uuid));
	}

}
