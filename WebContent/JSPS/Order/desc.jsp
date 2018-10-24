<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>当前订单</h3>
<p>订单号：${order.oid } <br/>提交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.ordertime }"/> <br/>订单金额：<font color="red">${order.total }元</font><br/> <a><font color="red">银行支付</font></a></p>
<table border="1">
	<tr>
		<td>图片</td>
		<td>书名</td>
		<td>作者</td>
		<td>版次</td>
		<td>出版社</td>
		<td>数量</td>
		<td>价格</td>
		<td>小计</td>
	</tr>
	<c:forEach items="${requestScope.order.orderItem}" var="orderItem">
		<tr>
			<td><img src="<c:url value='${orderItem.book.image }'/>" width="50" height="60"/></td>
			<td>${orderItem.book.bname }</td>
			<td>${orderItem.book.author }</td>
			<td>${orderItem.book.version }</td>
			<td>${orderItem.book.publish }</td>
			<td>${orderItem.count }</td>
			<td>${orderItem.book.price }元</td>
			<td>${orderItem.subtotal }元</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>