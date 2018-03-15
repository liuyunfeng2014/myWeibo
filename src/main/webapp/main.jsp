<%@page import="com.myWeibo.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	欢迎你<%
	User user = (User) session.getAttribute("userInfo");
%>
	<%=user.getUserName()%>
	<a href="http://localhost/myWeibo/logout.do">退出</a>
	<shiro:hasPermission name="user:update">
		<p>user:update</p>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:deletes">
		<p>user:delete</p>
	</shiro:hasPermission>
	<shiro:hasPermission name="user:create">
		<p>user:create</p>
	</shiro:hasPermission>
	<a href="editUser.html">edit User</a>
</body>
</html>