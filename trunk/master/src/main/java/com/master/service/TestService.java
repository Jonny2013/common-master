package com.master.service;

import java.util.List;

import com.master.model.Test;
import com.master.plugin.Page;

public interface TestService {
	public List<Test> listPageTest(Page page);
	
	public List<Test> listPageTest2(Test test);
	
	public void deleteTestById(Long id);
	
}
