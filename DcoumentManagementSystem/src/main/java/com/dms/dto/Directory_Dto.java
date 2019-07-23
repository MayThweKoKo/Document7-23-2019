package com.dms.dto;

public class Directory_Dto {
	
	public int id;
	public String name;
	public int parent_id;
	public int user_info_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getUser_info_id() {
		return user_info_id;
	}
	public void setUser_info_id(int user_info_id) {
		this.user_info_id = user_info_id;
	}
	
	
	
	
}
