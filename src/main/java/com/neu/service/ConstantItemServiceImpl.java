package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.ConstantItem;
import com.neu.entity.ConstantItemExample;
import com.neu.entity.ConstantType;
import com.neu.mapper.ConstantItemMapper;

@Service
public class ConstantItemServiceImpl implements ConstantItemService{

	@Autowired
	private ConstantItemMapper constantItemMapper;
	
	@Override
	public int insert(ConstantItem entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ConstantItem entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ConstantItem getById(int id) {
		return null;
	}

	@Override
	public PageInfo<ConstantItem> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConstantItem> getAll() {
		// TODO Auto-generated method stub
		return ConstantItemService.super.getAll();
	}

	@Override
	public List<ConstantItem> getByIds(int id) {
		ConstantItemExample example = new ConstantItemExample();
		ConstantType constantType = new ConstantType();
		constantType.setId(id);
		example.or().andConstantTypeEqualTo(constantType);
		return constantItemMapper.selectByExample(example);
	}
}
