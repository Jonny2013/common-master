package com.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.dao.TestMapper;
import com.master.model.Test;
import com.master.plugin.Page;
import com.master.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	private TestMapper testMapper;

	public TestMapper getTestMapper() {
		return testMapper;
	}

	@Autowired
	public void setTestMapper(TestMapper testMapper) {
		this.testMapper = testMapper;
	}

	public List<Test> listPageTest(Page page) {
		// TODO Auto-generated method stub
		return testMapper.listPageTest(page);
	}

	public List<Test> listPageTest2(Test test) {
		// TODO Auto-generated method stub
		return testMapper.listPageTest2(test);
	}

	public void deleteTestById(Long id) {
		// TODO Auto-generated method stub
		testMapper.deleteTestById(id);
	}


}
