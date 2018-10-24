package cn.jinty.bookstore.user.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import cn.jinty.bookstore.cart.domain.Cart;
import cn.jinty.bookstore.user.domain.User;
import cn.jinty.bookstore.user.service.UserException;
import cn.jinty.bookstore.user.service.UserService;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserService();
	public String regist(HttpServletRequest request,HttpServletResponse response)
	{
		User form=new User();
		form.setUsername(request.getParameter("username"));
		form.setPassword(request.getParameter("password"));
		form.setEmail(request.getParameter("email"));
		form.setUid(CommonUtils.uuid());
		form.setCode(CommonUtils.uuid()+CommonUtils.uuid());
		
		Map<String,String> errors = new HashMap<String,String>();
		String username=form.getUsername();
		if(username==null||username.trim().isEmpty()) {
				errors.put("username","用户名不能空");
		}else if(username.length()<3||username.length()>10) {
			    errors.put("username","长度必须在3-10之间");
		}
		String password=form.getPassword();
		if(password==null||password.trim().isEmpty()) {
			errors.put("password","密码不能空");
		}else if(password.length()<3||password.length()>10) {
			    errors.put("password","长度必须在3-10之间");
		}
		String email=form.getEmail();
		if(email==null||email.trim().isEmpty()) {
			errors.put("email","邮箱不能空");
		}else if(!email.matches("[A-Za-z0-9_]+@\\w+\\.\\w+")) {
			errors.put("email","email格式错误");
		}
		if(errors.size()>0) {
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "f:/JSPS/User/regist.jsp";
		}
		try {
			userService.regist(form);
			
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/JSPS/User/regist.jsp";
		}
		java.util.Properties props=new Properties();
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String host=props.getProperty("host");
		String userName=props.getProperty("userName");
		String passWord=props.getProperty("passWord");
		String from=props.getProperty("from");
		String to=form.getEmail();
		String subject=props.getProperty("subject");
		String content=props.getProperty("content");
		content=MessageFormat.format(content, form.getCode());
		Session session=MailUtils.createSession(host, userName, passWord);
		Mail mail=new Mail(from,to,subject,content);
		try {
			MailUtils.send(session, mail);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("msg", "注册成功！请到邮箱中激活");
		return "f:/JSPS/msg.jsp";
	}
	public String active(HttpServletRequest request,HttpServletResponse response) {
		String code=request.getParameter("code");
		try {
			userService.active(code);
			request.setAttribute("msg", "恭喜您激活成功");
			return "f:/JSPS/msg.jsp";
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			return "f:/JSPS/msg.jsp";
		}
	}
	public String login(HttpServletRequest request,HttpServletResponse response) {
		User form=new User();
		form.setUsername(request.getParameter("username"));
		form.setPassword(request.getParameter("password"));
		try {
			User user=userService.login(form);
			request.getSession().setAttribute("session_user", user);
			//给用户添加购物车到Session中
			request.getSession().setAttribute("cart", new Cart());
			return "r:/index.jsp";
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/JSPS/User/login.jsp";
		}
	}
	public String quit(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		return "r:/index.jsp";
	}
}
