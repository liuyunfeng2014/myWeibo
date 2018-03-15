package com.myWeibo.service;

import com.myWeibo.pojo.User;

public interface UserService {
	//用户验证
	User authentication(User user);
	
	 /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);
    
    
}
