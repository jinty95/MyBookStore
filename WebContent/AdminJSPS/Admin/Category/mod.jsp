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
<h3>修改分类</h3>
<form action="<c:url value='/AdminCategoryServlet'/>" method="post">
	<input type="hidden" name="method" value="edit"/>
	<input type="hidden" name="cid" value="${category.cid }"/>
	分类名称：<input type="text" name="category" value="${category.cname }"/><br/>
	<input type="submit" value="修改"/>
</form>
</body>
</html>