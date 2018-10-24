package cn.jinty.bookstore.cart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.book.domain.Book;
import cn.jinty.bookstore.book.service.BookService;
import cn.jinty.bookstore.cart.domain.Cart;
import cn.jinty.bookstore.cart.domain.CartItem;

public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		String bid=request.getParameter("bid");
		Book book=new BookService().loadBook(bid);
		int count= Integer.parseInt(request.getParameter("count"));
		CartItem cartItem=new CartItem();
		cartItem.setBook(book);
		cartItem.setCount(count);
		cart.add(cartItem);
		return "f:/JSPS/Cart/list.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		String bid=request.getParameter("bid");
		cart.delete(bid);
		return "f:/JSPS/Cart/list.jsp";
	}
	public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		cart.clear();
		return "f:/JSPS/Cart/list.jsp";
	}
	public String myCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		request.setAttribute("myCart",cart.getCartItems());
		return "f:/JSPS/Cart/list.jsp";
	}
}
