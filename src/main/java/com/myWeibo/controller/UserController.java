package com.myWeibo.controller;

import java.util.concurrent.SynchronousQueue;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myWeibo.pojo.User;
import com.myWeibo.service.UserService;



@Controller
public class UserController {
	@Resource(name="userService")
	private UserService Service;
	@RequestMapping("login.do")
	public String login(String userName,String userPwd,HttpSession session){
		try{
			Subject subject=SecurityUtils.getSubject();
			subject.login(new UsernamePasswordToken(userName, userPwd));
			User user=Service.selectByUsername(userName);
			session.setAttribute("userInfo", user);
		}catch (DisabledAccountException e) {
			// TODO: handle exception
			System.out.println("账号被禁用了");
			return "redirect:loginFail.html";
		}
		catch(AuthenticationException r){
			System.out.println("账号/密码错误");
			return "redirect:loginFail.html";
		}
		return "main";
	}
	@RequestMapping("logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login.html";
    }
}
