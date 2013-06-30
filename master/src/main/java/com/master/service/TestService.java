package com.master.service;

import java.util.List;

import com.master.model.Test;
import com.master.plugin.Page;

public interface TestService {
	public List<Test> listPageTest(Page page);
	
	public List<Test> listPageTest2(Test test);
	
	public void deleteTestById(Long id);
	
	public void insert(Test test);
	
	public Test getObject(Long id);
	
	public void updateObject(Test test);
	
}
