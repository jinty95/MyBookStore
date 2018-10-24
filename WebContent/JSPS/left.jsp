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
<div><a href="<c:url value='/BookServlet?method=findAll'/>" target="right">全部图书</a></div>
<c:forEach items="${categoryList }" var="category">
	<a href="<c:url value='/BookServlet?method=findByCategory&cid=${category.cid }'/>" target="right">${category.cname }</a><br/>
</c:forEach>
</body>
</html>