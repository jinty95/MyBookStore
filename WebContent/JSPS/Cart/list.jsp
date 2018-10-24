<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>我的购物车</h3>
<c:choose>
	<c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0 }">
		购物车空空如也，赶快挑选喜欢的书籍吧！
	</c:when>
	<c:otherwise>
<table border="1">
	<tr>
		<td>图片</td>
		<td>书名</td>
		<td>作者</td>
		<td>版次</td>
		<td>出版社</td>
		<td>价格</td>
		<td>数量</td>
		<td>小计</td>
	</tr>
	<c:forEach items="${sessionScope.cart.cartItems}" var="cartItem">
		<tr>
			<td><img alt="" src="<c:url value='${cartItem.book.image }'/>" width="50" height="60"/></td>
			<td>${cartItem.book.bname}</td>
			<td>${cartItem.book.author}</td>
			<td>${cartItem.book.version}</td>
			<td>${cartItem.book.publish}</td>
			<td>${cartItem.book.price}元</td>
			<td>${cartItem.count}本</td>
			<td>${cartItem.subtotal}元</td>
			<td><a href="<c:url value='/CartServlet?method=delete&bid=${cartItem.book.bid}'/>">删除</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td>合计</td>
		<td>${sessionScope.cart.total}元</td>
		<td><a href="<c:url value='/OrderServlet?method=add'/>">提交订单</a></td>
		<td><a href="<c:url value='/CartServlet?method=clear'/>">清空购物车</a></td>
	</tr>
</table>
	</c:otherwise>
</c:choose>

</body>
</html>