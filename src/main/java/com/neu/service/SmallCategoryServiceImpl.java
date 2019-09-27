package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.LargerCategory;
import com.neu.entity.SmallCategory;
import com.neu.entity.SmallCategoryExample;
import com.neu.entity.SmallCategoryExample.Criteria;
import com.neu.mapper.SmallCategoryMapper;

@Service
public class SmallCategoryServiceImpl implements SmallCategoryService {
	@Autowired
	private SmallCategoryMapper smallCategoryMapper;

	// 小分类的增加
	@Override
	public int insert(SmallCategory entity) {
		return smallCategoryMapper.insert(entity);
	}

	// 小分类的更新
	@Override
	public int update(SmallCategory entity) {
		return smallCategoryMapper.updateByPrimaryKeySelective(entity);
	}

	// 小分裂的分类
	@Override
	public int delete(int id) {
		return smallCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SmallCategory getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	// 模糊查询小分类
	@Override
	public PageInfo<SmallCategory> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		SmallCategoryExample example = new SmallCategoryExample();
		Criteria criteria = example.or().andTypeNameLike("%" + (params.get("type_name")) + "%");
		if (criteria != null) {
			List<SmallCategory> list = smallCategoryMapper.selectByExample(example);
			PageInfo<SmallCategory> pageInfo = new PageInfo<>(list);
			return pageInfo;

		}
		return null;

	}

	@Override
	public PageInfo<SmallCategory> getPagedSelective(int pageNum, int pageSize,Map<String, Object> params) {
		SmallCategoryExample example = new SmallCategoryExample();
		PageHelper.startPage(pageNum, pageSize);
		
		if (params != null && params.size() != 0) {
			Integer id = (Integer) params.get("largercategory");
			LargerCategory largerCategory = new LargerCategory();
			largerCategory.setId(id);
			example.or().andLargercategoryEqualTo(largerCategory);
		}
		
		List<SmallCategory> list = smallCategoryMapper.selectByExample(example);
		PageInfo<SmallCategory> pageInfo = new PageInfo<>(list); 
		return pageInfo;
	}
	
	@Override
	public List<SmallCategory> getAll(int id) {
		SmallCategoryExample example = new SmallCategoryExample();
		if(id != -1) {
			LargerCategory largerCategory = new LargerCategory();
			largerCategory.setId(id);
			example.or().andLargercategoryEqualTo(largerCategory);
		}
		return smallCategoryMapper.selectByExample(example);
	}

}
