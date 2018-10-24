<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBookStore</title>
</head>
<body>
<h1>爪哇书店</h1>
<c:choose>
	<c:when test="${empty sessionScope.session_user }">
		<a href="<c:url value='/JSPS/User/regist.jsp'/>">注册</a>|<a href="<c:url value='/JSPS/User/login.jsp'/>">登录</a>|<a href="<c:url value='/AdminJSPS/login.jsp'/>">管理员入口</a>
	</c:when>
	<c:otherwise>
		您好：${sessionScope.session_user.username} <a href="<c:url value='/UserServlet?method=quit'/>">退出</a>|
		<a href="<c:url value='/JSPS/Cart/list.jsp'/>" target="right">我的购物车</a>
		<a href="<c:url value='/OrderServlet?method=myOrders'/>" target="right">我的订单</a>
		
	</c:otherwise>
</c:choose>
<hr/>
<iframe width="120" height="500" src="<c:url value='/CategoryServlet?method=findAll'/>" name="left"></iframe>
<iframe width="660" height="500" name="right"></iframe>
</body>
</html>