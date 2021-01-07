package com.springmvc.service;

import com.springmvc.model.User;

public interface UserService {

	void createUser(User user);

	void removeUser(User user);

	User getUserByUuid(String uuid);

}
