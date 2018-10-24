package cn.jinty.bookstore.cart.domain;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> map=new LinkedHashMap<String,CartItem>();
	public void add(CartItem cartItem) {
		if(map.containsKey(cartItem.getBook().getBid())) {
			CartItem ct=map.get(cartItem.getBook().getBid());
			ct.setCount(ct.getCount()+cartItem.getCount());
			map.put(cartItem.getBook().getBid(), ct);
		}else {
			map.put(cartItem.getBook().getBid(), cartItem);
		}
	}
	public void clear() {
		map.clear();
	}
	public void delete(String bid) {
		map.remove(bid);
	}
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	public double getTotal()
	{
		BigDecimal total=new BigDecimal(0);
		for(CartItem ct:map.values()) {
			BigDecimal subtotal=new BigDecimal(ct.getSubtotal()+"");
			total=total.add(subtotal);
		}
		return total.doubleValue();
	}
}
