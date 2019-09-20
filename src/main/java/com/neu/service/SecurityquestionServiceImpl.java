package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.Securityquestion;
import com.neu.entity.SecurityquestionExample;
import com.neu.entity.User;
import com.neu.mapper.SecurityquestionMapper;

@Service
public class SecurityquestionServiceImpl implements SecurityquestionService {

	@Autowired
	private SecurityquestionMapper mapper;
	
	@Override
	public int insert(Securityquestion entity) {
		int n = mapper.insertSelective(entity);
		return n;
	}

	@Override
	public int update(Securityquestion entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Securityquestion getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Securityquestion> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Securityquestion> getByUserId(int userId) {
		SecurityquestionExample example = new SecurityquestionExample();
		User user = new User();
		user.setId(userId);
		
		example.or().andUserEqualTo(user);
		List<Securityquestion> list = mapper.selectByExample(example);
		return list;
	}

}
