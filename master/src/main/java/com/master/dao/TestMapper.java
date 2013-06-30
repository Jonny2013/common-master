package com.master.dao;

import java.util.List;

import com.master.model.Test;
import com.master.plugin.Page;


public interface TestMapper {
	//单纯分页
	public List<Test> listPageTest(Page page);
	//带实体参数的分页
	public List<Test> listPageTest2(Test test);;
	//删除test数据
	public void deleteTestById(Long id);
	//插入数据
	public void insert(Test test);
	//查找Test
	public Test getObject(Long id);
	//更新Test
	public void updateObject(Test test);
}
