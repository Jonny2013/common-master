package com.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.dao.RoleMapper;
import com.master.model.Role;
import com.master.service.RoleService;

@Service("userService")
public class RoleServiceImpl implements RoleService {

	private RoleMapper roleMapper;
	

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}


	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleMapper.getAll();
	}

}
