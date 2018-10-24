<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookStoreHome</title>
</head>
<body>
<h1>爪哇书店后台管理中心</h1>
<c:if test="${not empty admin }">
	欢迎您！亲爱的${admin.aname }管理员
</c:if>|<a href="<c:url value='/index.jsp'/>">返回主页</a><hr/>
<iframe width="120" height="500" src="<c:url value='/AdminJSPS/Admin/left.jsp'/>" name="left"></iframe>
<iframe width="660" height="500" name="right"></iframe>
</body>
</html>