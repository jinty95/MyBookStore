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
<font color="yellow" style="background:gray">分类管理：</font><br/>
<a href="<c:url value='/AdminCategoryServlet?method=findAll'/>" target="right">查看分类</a><br/>
<a href="<c:url value='/AdminJSPS/Admin/Category/add.jsp'/>" target="right">添加分类</a><br/>
<font color="yellow" style="background:gray">图书管理：</font><br/>
<a href="<c:url value='/AdminBookServlet?method=findAll'/>" target="right">查看图书</a><br/>
<a href="<c:url value='/AdminBookServlet?method=addPre'/>" target="right">添加图书</a><br/>
<font color="yellow" style="background:gray">订单管理：</font><br/>
<a href="<c:url value='/AdminOrderServlet?method=findAll'/>" target="right">所有订单</a><br/>
<a href="<c:url value='/AdminOrderServlet?method=findByState&ostate=1'/>" target="right">未付款订单</a><br/>
<a href="<c:url value='/AdminOrderServlet?method=findByState&ostate=2'/>" target="right">已付款订单</a><br/>
<a href="<c:url value='/AdminOrderServlet?method=findByState&ostate=3'/>" target="right">未收货订单</a><br/>
<a href="<c:url value='/AdminOrderServlet?method=findByState&ostate=4'/>" target="right">已完成订单</a><br/>
</body>
</html>