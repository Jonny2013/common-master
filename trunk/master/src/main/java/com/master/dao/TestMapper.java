package com.master.dao;

import java.util.List;

import com.master.model.Test;
import com.master.plugin.Page;


public interface TestMapper {

	public List<Test> listPageTest(Page page);
	
	public List<Test> listPageTest2(Test test);;
}
