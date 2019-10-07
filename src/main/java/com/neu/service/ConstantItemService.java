package com.neu.service;

import java.util.List;

import com.neu.entity.ConstantItem;

public interface ConstantItemService extends IService<ConstantItem> {

	List<ConstantItem> getByIds(int id);
}
