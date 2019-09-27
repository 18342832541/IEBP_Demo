package com.neu.service;

import com.github.pagehelper.PageInfo;
import com.neu.entity.LargerCategory;

public interface LargerCategoryService extends IService<LargerCategory> {

	PageInfo<LargerCategory> getPaged(int pageNum, int pageSize);

}
