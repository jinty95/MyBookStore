package cn.jinty.bookstore.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.book.domain.Book;
import cn.jinty.bookstore.book.service.BookService;

public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookService();
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Book> list=bs.findAll();
		request.setAttribute("bookList", list);
		return "f:/JSPS/right.jsp";
	}
	public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
		List<Book> list=bs.findByCategory(cid);
		request.setAttribute("bookList", list);
		return "f:/JSPS/right.jsp";
	}
	public String loadBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid=request.getParameter("bid");
		Book book=bs.loadBook(bid);
		request.setAttribute("book", book);
		return "f:/JSPS/Book/description.jsp";
	}
}
