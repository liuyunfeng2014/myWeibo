package com.myWeibo.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.myWeibo.mapper.UserMapper;
import com.myWeibo.pojo.User;
import com.myWeibo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper mapper;
	public User authentication(User user) {
		// TODO Auto-generated method stub
		User users=mapper.authentication(user);
		return users;
	}
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		return mapper.selectByUsername(username);
	}


}
