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
<h3>添加分类</h3>
<form action="<c:url value='/AdminCategoryServlet'/>" method="post">
	<input type="hidden" name="method" value="add"/>
	类名:<input type="text" name="category"/><br/>
	<input type="submit" value="添加"/>
</form>
</body>
</html>