package com.myWeibo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myWeibo.mapper.RoleMapper;
import com.myWeibo.pojo.Role;
import com.myWeibo.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper mapper;

	public List<Role> selectRolesByUserId(int userId) {
		// TODO Auto-generated method stub
		return mapper.selectRolesByUserId(userId);
	}

}
