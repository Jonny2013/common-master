package com.master.dao;

import java.util.List;

import com.master.model.Test;
import com.master.plugin.Page;


public interface TestMapper {

	List<Test> listPageTest(Page page);
	
}
