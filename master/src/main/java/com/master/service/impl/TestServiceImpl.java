package com.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.dao.TestMapper;
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


}
