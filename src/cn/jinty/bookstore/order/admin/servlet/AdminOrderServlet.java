package cn.jinty.bookstore.order.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.order.domain.Order;
import cn.jinty.bookstore.order.service.OrderService;

public class AdminOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os=new OrderService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orderList=os.allOrders();
		request.setAttribute("orderList", orderList);
		return "f:/AdminJSPS/Admin/Order/list.jsp";
	}
	public String findByState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stateStr=request.getParameter("ostate");
		List<Order> orderList=os.findByState(Integer.parseInt(stateStr));
		request.setAttribute("orderList", orderList);
		return "f:/AdminJSPS/Admin/Order/list.jsp";
	}
}
