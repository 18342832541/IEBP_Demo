package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.User;
import com.neu.entity.UserInfo;
import com.neu.entity.UserInfoExample;
import com.neu.mapper.UserInfoMapper;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public int insert(UserInfo entity) {
		return userInfoMapper.insertSelective(entity);

	}

	@Override
	public int update(UserInfo entity) {
		return userInfoMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo getById(int id) {
		UserInfoExample example = new UserInfoExample();
		User user = new User();
		user.setId(id);
		example.or().andUserEqualTo(user);
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		if(list != null && list.size() != 0) {
			return list.get(0);
		}
		return null;

	}

	@Override
	public PageInfo<UserInfo> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
