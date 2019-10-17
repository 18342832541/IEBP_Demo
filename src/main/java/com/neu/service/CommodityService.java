package com.neu.service;

import java.util.Map;

import com.neu.entity.Commodity;
import com.neu.entity.LargerCategory;
import com.neu.entity.SmallCategory;

public interface CommodityService extends IService<Commodity> {

	/*int getByCountById(Map<String, Integer> map);*/
	int deleteByLg(LargerCategory lgCategory);
	int deleteBySm(SmallCategory smCategory);

}
