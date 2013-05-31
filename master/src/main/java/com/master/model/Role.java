package com.master.model;

/*
 * 角色表
 */
public class Role {
	
	//主键id
	private Long id;
	//描述
	private String description;
	//角色名
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
