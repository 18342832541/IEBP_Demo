package com.neu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.Role;
import com.neu.entity.User;
import com.neu.entity.UserExample;
import com.neu.entity.UserExample.Criteria;
import com.neu.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int insert(User entity) {
		
		return userMapper.insertSelective(entity);
	}

	@Override
	public int update(User entity) {
		
		return userMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int delete(int id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User getById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<User> getPaged(int pageNum, int pageSize, Role role, User nowUser) {
		PageHelper.startPage(pageNum, pageSize);
		UserExample example = new UserExample();
		List<Role> roles = new ArrayList<Role>();
		
		Criteria criteria = example.or();
		Role nowRole = nowUser.getRole();
		if(nowRole.getId() == 3) {
			roles.add(new Role(2));
		}else if(nowRole.getId() == 4) {
			roles.add(new Role(2));
			roles.add(new Role(3));
		}else {
			roles.add(new Role(2));
			roles.add(new Role(3));
			roles.add(new Role(4));
		}
		criteria.andRoleIn(roles);
		
		if (role != null && role.getId() != 0){
			criteria.andRoleEqualTo(role);
		}
		
		List<User> list = userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
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

	@Override
	public User getUserId(String username) {
		UserExample example = new UserExample();
		example.or().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(list != null && list.size() != 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public PageInfo<User> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
