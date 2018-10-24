package cn.jinty.bookstore.book.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.book.domain.Book;
import cn.jinty.bookstore.book.service.BookService;
import cn.jinty.bookstore.category.domain.Category;
import cn.jinty.bookstore.category.service.CategoryService;

public class AdminBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookService();
	private CategoryService cs=new CategoryService();
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("bookList", bs.findAll());
		return "f:/AdminJSPS/Admin/Book/list.jsp";
	}
	public String loadBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid=request.getParameter("bid");
		Book book=bs.loadBook(bid);
		List<Category> categoryList=cs.findAll();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("book", book);
		return "f:/AdminJSPS/Admin/Book/desc.jsp";
	}
	public String addPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categoryList=cs.findAll();
		request.setAttribute("categoryList", categoryList);
		return "f:/AdminJSPS/Admin/Book/add.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid=request.getParameter("bid");
		bs.delete(bid);
		return findAll(request,response);
	}
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book=CommonUtils.toBean(request.getParameterMap(), Book.class);
		Category category=CommonUtils.toBean(request.getParameterMap(), Category.class);
		book.setCategory(category);
		bs.update(book);
		return findAll(request,response);
	}
}
