package com.master.dao;

import java.util.List;

import com.master.model.Role;

public interface RoleMapper {
  
	//获取全部角色
	public List<Role> getAll();
	
}