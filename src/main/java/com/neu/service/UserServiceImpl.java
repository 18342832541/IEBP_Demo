package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.User;
import com.neu.entity.UserExample;
import com.neu.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insert(User entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<User> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		UserExample example = new UserExample();
		example.or().andUsernameEqualTo(username).andPasswordEqualTo(password);
		
		List<User> list = userMapper.selectByExample(example);
		if(list != null && list.get(0) != null) {
			return list.get(0);
		}else {
			return null;
		}
		
	}

}
