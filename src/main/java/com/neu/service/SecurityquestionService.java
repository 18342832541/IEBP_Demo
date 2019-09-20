package com.neu.service;

import java.util.List;

import com.neu.entity.Securityquestion;

public interface SecurityquestionService extends IService<Securityquestion> {
	List<Securityquestion> getByUserId(int userId);

}
