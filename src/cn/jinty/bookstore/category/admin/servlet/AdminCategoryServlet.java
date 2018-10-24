package cn.jinty.bookstore.category.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.category.domain.Category;
import cn.jinty.bookstore.category.service.CategoryService;

public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService cs=new CategoryService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categoryList", cs.findAll());		
		return "f:/AdminJSPS/Admin/right.jsp";
	}
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname=request.getParameter("category");
		Category category=new Category();
		category.setCname(cname);
		category.setCid(CommonUtils.uuid());
		cs.add(category);
		return findAll(request,response);
	}
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		try{
			cs.delete(cid);
			return findAll(request,response);
		}catch(CategoryException e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/AdminJSPS/Admin/msg.jsp";
		}
	}
	public String editPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		request.setAttribute("category", cs.load(cid));
		return "f:/AdminJSPS/Admin/Category/mod.jsp";
	}
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		String cname=request.getParameter("category");
		Category category=new Category();
		category.setCid(cid);
		category.setCname(cname);
		cs.edit(category);
		request.setAttribute("msg", "修改成功");
		return "f:/AdminJSPS/Admin/msg.jsp";
	}
}
