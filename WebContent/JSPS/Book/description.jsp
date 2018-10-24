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
<img alt="" src="<c:url value='${book.image }'/>" width="150" height="180"/><br/>
书名：${book.bname }<br/>
价格：${book.price }元<br/>
作者：${book.author }<br/>
版次：第${book.version }版<br/>
出版：${book.publish }<br/>
<form action="<c:url value='/CartServlet'/>" method="post">
	<input type="hidden" name="method" value="add"/>
	<input type="hidden" name="bid" value="${book.bid }"/>	
	<c:choose>
		<c:when test="${not empty sessionScope.session_user}">
		数量：<input type="text" name="count" value="1"/>
		<input type="submit" value="添加到购物车"/>
		</c:when>
	</c:choose>
</form>
</body>
</html>