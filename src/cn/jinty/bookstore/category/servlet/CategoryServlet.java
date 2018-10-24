package cn.jinty.bookstore.category.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.category.service.CategoryService;

public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService cs=new CategoryService();
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categoryList", cs.findAll());
		return "f:/JSPS/left.jsp";
	}
	
}
