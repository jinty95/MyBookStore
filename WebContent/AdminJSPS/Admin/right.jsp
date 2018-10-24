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
	<h3 >分类列表</h3>
	<table border="1">
		<tr>
			<td>类名</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${categoryList }" var="category">
			<tr>
				<td>${category.cname }</td>
				<td><a href="<c:url value='/AdminCategoryServlet?method=editPre&cid=${category.cid}'/>">修改</a>|<a href="<c:url value='/AdminCategoryServlet?method=delete&cid=${category.cid }'/>" onclick="return confirm('确定删除吗？')">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>