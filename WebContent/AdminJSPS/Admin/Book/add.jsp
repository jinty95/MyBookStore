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
<form action="<c:url value='/AdminAddServlet'/>" method="post" enctype="multipart/form-data">
	图书图片：<input type="file" name="image"/><br/>
	图书名称：<input type="text" name="bname"/><br/>
	图书价格：<input type="text" name="price"/>元<br/>
	图书作者：<input type="text" name="author"/><br/>
	图书版次：<input type="text" name="version"/>版<br/>
	图书出版：<input type="text" name="publish"/><br/>
	图书类别：<select name="cid">
		<c:forEach items="${categoryList }" var="c">
			<option value="${c.cid }">${c.cname}</option>
		</c:forEach>
	</select><br/>
	<input type="hidden" name="del" value="false"/>
	<input type="submit" value="添加"/>
</form>
</body>
</html>