package cn.jinty.bookstore.order.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;
import cn.jinty.bookstore.order.dao.OrderDao;
import cn.jinty.bookstore.order.domain.Order;

public class OrderService {
	private OrderDao od=new OrderDao();
	public void add(Order order)
	{
		//事务处理
		try {
			JdbcUtils.beginTransaction();
			
			od.addOrder(order);
			od.addOrderItemList(order.getOrderItem());
			
			JdbcUtils.commitTransaction();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public List<Order> myOrders(String uid){
		return od.findByUid(uid);
	}
	public Order loadOrder(String oid) {
		return od.loadOrder(oid);
	}
	public void confirm(String oid)throws OrderException
	{
		int state=od.getStateByOid(oid);
		if(state!=3)throw new OrderException("订单异常");
		od.updateState(oid, 4);
	}
	public List<Order> allOrders() {
		// TODO Auto-generated method stub
		return od.findAllOrders();
	}
	public List<Order> findByState(int ostate) {
		// TODO Auto-generated method stub
		return od.findByState(ostate);
	}
}	
