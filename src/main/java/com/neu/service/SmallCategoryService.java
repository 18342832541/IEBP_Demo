package com.neu.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.neu.entity.SmallCategory;

public interface SmallCategoryService extends IService<SmallCategory> {

	PageInfo<SmallCategory> getPagedSelective(int pageNum, int pageSize, Map<String, Object> params);

	List<SmallCategory> getAll(int id);
}
