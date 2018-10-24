package cn.jinty.bookstore.order.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.jinty.bookstore.book.domain.Book;
import cn.jinty.bookstore.order.domain.Order;
import cn.jinty.bookstore.order.domain.OrderItem;
import cn.jinty.bookstore.user.domain.User;

public class OrderDao {
	private QueryRunner qr=new TxQueryRunner();
	public void addOrder(Order order) {
		String sql="insert into orders values(?,?,?,?,?,?)";
		//util.Date--sql.Date
		Timestamp ts=new Timestamp(order.getOrdertime().getTime());
		Object[] params= {order.getOid(),ts,order.getTotal(),order.getOstate(),order.getUser().getUid(),order.getAddress()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addOrderItemList(List<OrderItem> orderItemList)
	{
		String sql="insert into orderitem values(?,?,?,?,?)";
		Object[][] params=new Object[orderItemList.size()][];
		for(int i=0;i<orderItemList.size();i++) {
			OrderItem oi=orderItemList.get(i);
			params[i]= new Object[] {
				oi.getIid(),oi.getCount(),oi.getSubtotal(),oi.getOrder().getOid(),oi.getBook().getBid()
			};
		}
		try {
			qr.batch(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Order> findByUid(String uid){
		String sql="select * from orders where uid=?";
		try {
			List<Order> orderList=qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
			for(Order order:orderList) {
				loadOrderItems(order);
			}
			return orderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private void loadOrderItems(Order order) {
		String sql="select * from orderitem o,book b where o.bid=b.bid and oid=?";
		try {
			List<OrderItem> list=new ArrayList<OrderItem>();
			List<Map<String,Object>> oiList=(List<Map<String, Object>>) qr.query(sql, new MapListHandler(),order.getOid());
			for(Map<String,Object> map:oiList) {
				OrderItem orderItem=CommonUtils.toBean(map,OrderItem.class);
				Book book=CommonUtils.toBean(map, Book.class);
				orderItem.setBook(book);
				list.add(orderItem);
			}
			order.setOrderItem(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Order loadOrder(String oid) {
		String sql="select * from orders where oid=?";
		try {
			Order order=qr.query(sql, new BeanHandler<Order>(Order.class),oid);
			loadOrderItems(order);
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int getStateByOid(String oid) {
		String sql="select ostate from orders where oid=?";
		try {
			Number num=(Number) qr.query(sql, new ScalarHandler(),oid);
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public void updateState(String oid,int state) {
		String sql="update orders set ostate=? where oid=?";
		try {
			qr.update(sql, state,oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		String sql="select * from orders o,user u where o.uid=u.uid";
		try {
			List<Map<String, Object>> mapList=qr.query(sql, new MapListHandler());
			List<Order> orderList=new ArrayList<Order>();
			for(Map<String, Object> map:mapList) {
				Order o=CommonUtils.toBean(map, Order.class);
				User u=CommonUtils.toBean(map, User.class);
				o.setUser(u);
				orderList.add(o);
			}
			for(Order order:orderList) {
				loadOrderItems(order);
			}
			return orderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Order> findByState(int ostate) {
		// TODO Auto-generated method stub
		String sql="select * from orders o,user u where o.uid=u.uid and o.ostate=?";
		try {
			List<Map<String, Object>> mapList=qr.query(sql, new MapListHandler(),ostate);
			List<Order> orderList=new ArrayList<Order>();
			for(Map<String, Object> map:mapList) {
				Order o=CommonUtils.toBean(map, Order.class);
				User u=CommonUtils.toBean(map, User.class);
				o.setUser(u);
				orderList.add(o);
			}
			for(Order order:orderList) {
				loadOrderItems(order);
			}
			return orderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
