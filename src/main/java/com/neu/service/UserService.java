package com.neu.service;

import com.neu.entity.User;

public interface UserService extends IService<User> {

	User login(String username, String password);
	
	User getUserId(String username);
}
