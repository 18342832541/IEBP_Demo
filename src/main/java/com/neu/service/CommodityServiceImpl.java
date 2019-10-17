package com.neu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neu.entity.Commodity;
import com.neu.entity.CommodityExample;
import com.neu.entity.CommodityExample.Criteria;
import com.neu.entity.LargerCategory;
import com.neu.entity.LargerCategoryExample;
import com.neu.entity.SmallCategory;
import com.neu.mapper.CommodityMapper;

@Service
public class CommodityServiceImpl implements CommodityService {
	@Autowired
	private CommodityMapper commodityMapper;

	// 增加新商品
	@Override
	public int insert(Commodity entity) {
		return commodityMapper.insert(entity);
	}

	// 修改商品
	@Override
	public int update(Commodity entity) {
		return commodityMapper.updateByPrimaryKeySelective(entity);
	}

	// 删除商品
	@Override
	public int delete(int id) {
		return commodityMapper.deleteByPrimaryKey(id);
	}

	// 查询商品信息
	@Override
	public Commodity getById(int id) {
		return commodityMapper.selectByPrimaryKey(id);

	}
	
/*	@Override
	public int getByCountById(Map<String,Integer> map) {
		CommodityExample example = new CommodityExample();
		if(map.get("lgId") != null) {
			LargerCategory largerCategory = new LargerCategory();
			largerCategory.setId(map.get("lgId"));
			example.or().andLargercategoryEqualTo(largerCategory);
		}
		if(map.get("lgId") != null) {
			LargerCategory largerCategory = new LargerCategory();
			largerCategory.setId(map.get("lgId"));
			example.or().andLargercategoryEqualTo(largerCategory);
		}
		return commodityMapper.selectByPrimaryKey(id);

	}*/

	// 商品名字模糊查询
	@Override
	public PageInfo<Commodity> getPaged(int pageNum, int pageSize, Map<String, Object> params) {
		PageHelper.startPage(pageNum, pageSize);
		CommodityExample example = new CommodityExample();
		Criteria criteria = example.or();
		if (!(params.isEmpty())){
			if(params.get("comName") != null) {
				criteria.andComnameLike("%" + (String) params.get("comName") + "%");
			};
			if(params.get("largercategory") != null) {
				Integer id = (Integer) params.get("largercategory");
				LargerCategory largerCategory = new LargerCategory();
				largerCategory.setId(id);
				criteria.andLargercategoryEqualTo(largerCategory);
			};
			if(params.get("smallcategory") != null) {
				Integer id = (Integer) params.get("smallcategory");
				SmallCategory smallCategory = new SmallCategory();
				smallCategory.setId(id);
				criteria.andSmallcategoryEqualTo(smallCategory);
			};
		}
		
		List<Commodity> list = commodityMapper.selectByExample(example);
		PageInfo<Commodity> pageInfo = new PageInfo<>(list);
		return pageInfo;

	}

	@Override
	public List<Commodity> getAll() {
		return null;

	}

	@Override
	public int deleteByLg(LargerCategory lgCategory) {
		CommodityExample example = new CommodityExample();
		example.or().andLargercategoryEqualTo(lgCategory);
		return commodityMapper.deleteByExample(example);
	}

	@Override
	public int deleteBySm(SmallCategory smCategory) {
		CommodityExample example = new CommodityExample();
		example.or().andSmallcategoryEqualTo(smCategory);
		return commodityMapper.deleteByExample(example);
	}

}
