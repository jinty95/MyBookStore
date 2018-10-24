package cn.jinty.bookstore.user.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jinty.bookstore.user.domain.Admin;
import cn.jinty.bookstore.user.service.AdminException;
import cn.jinty.bookstore.user.service.UserService;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		admin.setAname(request.getParameter("aname"));
		admin.setPassword(request.getParameter("password"));
		Admin ad=null;
		try {
			ad=us.adminLogin(admin);
			request.getSession().setAttribute("admin", ad);
			request.getRequestDispatcher("/AdminJSPS/Admin/index.jsp").forward(request, response);
		} catch (AdminException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("/AdminJSPS/login.jsp").forward(request, response);
		}
	}

}
