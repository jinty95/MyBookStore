package cn.jinty.bookstore.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.cart.domain.Cart;
import cn.jinty.bookstore.cart.domain.CartItem;
import cn.jinty.bookstore.order.domain.Order;
import cn.jinty.bookstore.order.domain.OrderItem;
import cn.jinty.bookstore.order.service.OrderException;
import cn.jinty.bookstore.order.service.OrderService;
import cn.jinty.bookstore.user.domain.User;

public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService os=new OrderService();
	
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		Order order=new Order();
		order.setOid(CommonUtils.uuid());
		order.setOrdertime(new Date());
		order.setOstate(1);
		order.setUser((User)request.getSession().getAttribute("session_user"));
		order.setTotal(cart.getTotal());
		
		List<OrderItem> oiList=new ArrayList<OrderItem>();
		for(CartItem ct:cart.getCartItems()) {
			OrderItem oi=new OrderItem();
			oi.setIid(CommonUtils.uuid());
			oi.setCount(ct.getCount());
			oi.setBook(ct.getBook());
			oi.setSubtotal(ct.getSubtotal());
			oi.setOrder(order);
			oiList.add(oi);
		}		
		order.setOrderItem(oiList);
		cart.clear();
		os.add(order);
		request.setAttribute("order", order);
		return "f:/JSPS/Order/desc.jsp";
	}
	public String myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("session_user");
		List<Order> orderList=os.myOrders(user.getUid());
		request.setAttribute("orderList", orderList);
		return "f:/JSPS/Order/list.jsp";
	}
	public String loadOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oid = request.getParameter("oid");
		Order order=os.loadOrder(oid);
		request.setAttribute("order", order);
		return "f:/JSPS/Order/desc.jsp";
	}	
	public String confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oid=request.getParameter("oid");
		try {
			os.confirm(oid);
			request.setAttribute("msg", "交易成功");
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/JSPS/msg.jsp";
	}
}
