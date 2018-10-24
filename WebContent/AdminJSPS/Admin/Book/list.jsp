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
<c:forEach items="${bookList }" var="book">
	<div style="float: left">
	<a href="<c:url value='/AdminBookServlet?method=loadBook&bid=${book.bid }'/>"><img alt="" src="<c:url value='${book.image }'/>" width="150" height="180"/></a>  <br/>
	<a href="<c:url value='/AdminBookServlet?method=loadBook&bid=${book.bid }'/>">${book.bname }</a>
	</div>
</c:forEach>
</body>
</html>