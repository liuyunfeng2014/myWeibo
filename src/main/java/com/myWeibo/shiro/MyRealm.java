package com.myWeibo.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.myWeibo.pojo.Permission;
import com.myWeibo.pojo.Role;
import com.myWeibo.pojo.User;
import com.myWeibo.service.PermissionService;
import com.myWeibo.service.RoleService;
import com.myWeibo.service.UserService;

@Component(value="myRealm")
public class MyRealm extends AuthorizingRealm{
	@Resource(name="userService")
	private UserService service;
	
	@Resource(name="roleService")
	private RoleService roleService;
	@Resource(name="permissionService")
	private PermissionService permissionService;
	//为当前用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		String userName=(String) principals.getPrimaryPrincipal();
		User user=service.selectByUsername(userName);
		List<Role> roles=roleService.selectRolesByUserId(user.getUserId());
		for(Role r : roles){
			authorizationInfo.addRole(r.getRoleSign());
			List<Permission> permissions=permissionService.selectPermissionsByRoleId(r.getRoleId());
			for(Permission p:permissions){
				authorizationInfo.addStringPermission(p.getPermissionSign());
			}
		}
		//添加了权限
		return authorizationInfo;
	}
	//验证当前的用户
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)  {
		String name=(String) token.getPrincipal();
		String pwd=new String((char[])token.getCredentials());
		User user=service.authentication(new User(name,pwd));
		if(user==null){
			throw new AuthenticationException("用户名或密码错误");
		}else if(user.getUserType()==0){
			throw new DisabledAccountException("账号被禁用了");
		}
		SimpleAuthenticationInfo authorizationInfo=new SimpleAuthenticationInfo(name,pwd,getName());
		System.out.println("验证通过");
		return authorizationInfo;
	}

}
