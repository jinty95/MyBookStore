package cn.jinty.bookstore.order.domain;

import java.util.Date;
import java.util.List;

import cn.jinty.bookstore.user.domain.User;

public class Order {
	private String oid;
	private Date ordertime;
	private double total;
	private int ostate;
	private User user;
	private String address;
	
	private List<OrderItem> orderItem;
	public void setOrderItem(List<OrderItem> orderItem){
		this.orderItem=orderItem;
	}
	public List<OrderItem> getOrderItem(){
		return orderItem;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getOstate() {
		return ostate;
	}
	public void setOstate(int ostate) {
		this.ostate = ostate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
