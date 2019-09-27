package com.neu.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.ConstantType;
import com.neu.mapper.ConstantTypeMapper;

@Service
public class ConstantTypeServiceImpl implements ConstantTypeService {
       @Autowired
       private ConstantTypeMapper constantTypeMapper;


	@Override
	public int insert(ConstantType entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ConstantType entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ConstantType getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<ConstantType> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
