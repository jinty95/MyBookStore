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
<h3>所有订单</h3>
<table border="1">
<c:forEach items="${orderList}" var="order">	<%-- items="orderList"是常量字符串，这里应该写items="${orderList}" --%>
	<tr>
		<td>用户：${order.user.username }</td>
		<td>订单号：${order.oid}</td>
		<td>提交时间：${order.ordertime}</td>
		<td>订单金额：${order.total}</td>
		<td>订单状态：
		<c:choose>
			<c:when test="${order.ostate eq 1}">未付款</c:when>
			<c:when test="${order.ostate eq 2}">等待发货</c:when>
			<c:when test="${order.ostate eq 3}">确认收货</c:when>
			<c:when test="${order.ostate eq 4}">订单完成</c:when>
		</c:choose>
		</td>
	</tr>
	<c:forEach items="${order.orderItem }" var="orderItem">
	<tr>
		<td><img src="<c:url value='${orderItem.book.image}'/>" width="50" height="60"></td>
		<td>书名：${orderItem.book.bname }</td>
		<td>数量：${orderItem.count }</td>
		<td>小计：${orderItem.subtotal }</td>
		<td></td>
	</tr>
	</c:forEach>
</c:forEach>
</table>
</body>
</html>