<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>管理员请登录</h1>
<h3 style="color:red">${msg }</h3>
<form action="<c:url value='/AdminServlet'/>" method="post">
	管理员账号：<input type="text" name="aname" value="${requestScope.admin.aname }"/><br/>
	管理员密码：<input type="password" name="password" value="${requestScope.admin.password }"/><br/>
	<input type="submit" value="登录"/>
</form>
<a href="<c:url value='/index.jsp'/>">返回主页</a>
</body>
</html>