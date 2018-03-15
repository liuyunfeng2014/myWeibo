package com.myWeibo.mapper;

import java.util.List;

import com.myWeibo.pojo.Role;


public interface RoleMapper {
	public List<Role> selectRolesByUserId(int userId);
}
