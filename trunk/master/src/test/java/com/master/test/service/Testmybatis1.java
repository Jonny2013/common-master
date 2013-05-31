package com.master.test.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.master.model.Role;
import com.master.service.RoleService;
import com.master.service.impl.RoleServiceImpl;
import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("production")
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:applicationContext-mybatis.xml","classpath:applicationContext-shiro.xml"})
public class Testmybatis1 {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Testmybatis1.class);

	public RoleService roleService;
	
 	public RoleService getRoleService() {
		return roleService;
	}

 	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}



	@Test
	public void test1(){
		List<Role> roles = roleService.getAll();
		System.out.println(JSON.toJSONString(roles));
	}

}
