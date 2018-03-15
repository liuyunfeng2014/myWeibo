package com.myWeibo.mapper;

import org.apache.ibatis.annotations.Param;

import com.myWeibo.pojo.User;


public interface UserMapper {
	User authentication(@Param("user") User user);
	
	User selectByUsername(@Param("name")String name);
}
