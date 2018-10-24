<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function setMethod(method){
		var methodEle=document.getElementById("me");
		methodEle.value=method;
	}
</script>
</head>
<body>
<img alt="" src="<c:url value='${book.image }'/>" width="200" height="180"/><br/>
<form action="<c:url value='/AdminBookServlet'/>" method="post">
	<input type="hidden" name="method" id="me"/>
	<input type="hidden" name="bid" value="${book.bid }"/>
	<input type="hidden" name="image" value="${book.image }"/>
	<input type="hidden" name="del" value="${book.del }"/>
图书名称：<input type="text" name="bname" value="${book.bname }"><br/>
图书价格：<input type="text" name="price" value="${book.price }">元<br/>
图书作者：<input type="text" name="author" value="${book.author }"><br/>
图书版次：<input type="text" name="version" value="${book.version }">版<br/>
图书出版：<input type="text" name="publish" value="${book.publish }"><br/>
图书类别：<select name="cid">
	<c:forEach items="${categoryList }" var="category">
		<option value="${category.cid }" <c:if test="${category.cid eq book.category.cid }">selected="selected"</c:if>>${category.cname }</option>
	</c:forEach>
</select><br/>
<input type="submit" value="修改" onclick="setMethod('update')"/>
<input type="submit" value="删除" onclick="setMethod('delete')"/>
</form>
</body>
</html>