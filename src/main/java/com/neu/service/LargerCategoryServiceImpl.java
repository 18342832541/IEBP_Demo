package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.LargerCategory;
import com.neu.entity.LargerCategoryExample;
import com.neu.mapper.LargerCategoryMapper;

@Service
public class LargerCategoryServiceImpl implements LargerCategoryService {
	@Autowired
	private LargerCategoryMapper largerCategoryMapper;

	// 大分类的增加
	@Override
	public int insert(LargerCategory entity) {

		return largerCategoryMapper.insert(entity);
	}

	// 大分类的增加
	@Override
	public int update(LargerCategory entity) {
		return largerCategoryMapper.updateByPrimaryKeySelective(entity);

	}

	// 大分类的删除
	@Override
	public int delete(int id) {
		return largerCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public LargerCategory getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	// 大分类的名字模糊查询
	@Override
	public PageInfo<LargerCategory> getPaged(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		LargerCategoryExample example = new LargerCategoryExample();

		List<LargerCategory> list = largerCategoryMapper.selectByExample(example);
		PageInfo<LargerCategory> pageInfo = new PageInfo<>(list);
		return pageInfo;

	}

	@Override
	public List<LargerCategory> getAll() {
		return largerCategoryMapper.selectByExample(new LargerCategoryExample());
	}

	@Override
	public PageInfo<LargerCategory> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
