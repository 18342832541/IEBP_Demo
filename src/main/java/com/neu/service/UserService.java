package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.Role;
import com.neu.entity.User;

public interface UserService extends IService<User> {

	User login(String username, String password);
	
	User getUserId(String username);

	PageInfo<User> getPaged(int pageNum, int pageSize, Role role, User nowUser);
}
