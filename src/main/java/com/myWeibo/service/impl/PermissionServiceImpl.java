package com.myWeibo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myWeibo.mapper.PermissionMapper;
import com.myWeibo.pojo.Permission;
import com.myWeibo.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
	@Resource
	private PermissionMapper permissionMapper;

	public List<Permission> selectPermissionsByRoleId(int roleId) {
		// TODO Auto-generated method stub
		return permissionMapper.selectPermissionsByRoleId(roleId);
	}

}
