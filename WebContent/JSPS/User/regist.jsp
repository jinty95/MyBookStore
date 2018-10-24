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
<h1>注册</h1>
${msg }
<form action="<c:url value='/UserServlet'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	账号：<input type="text" name="username" value="${form.username }"/>${errors.username }<br/>
	密码：<input type="password" name="password" value="${form.password }"/>${errors.password }<br/>
	邮箱：<input type="text" name="email" value="${form.email }"/>${errors.email }<br/>
	<input type="submit" value="注册"/><br/>
</form>
<a href="<c:url value='/index.jsp'/>">返回主页</a>
</body>
</html>