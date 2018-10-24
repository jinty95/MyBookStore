package cn.jinty.bookstore.user.service;

import cn.jinty.bookstore.user.dao.UserDao;
import cn.jinty.bookstore.user.domain.Admin;
import cn.jinty.bookstore.user.domain.User;

public class UserService {
	private UserDao userDao=new UserDao();
	public void regist(User form) throws UserException{
		User user=userDao.findByUsername(form.getUsername());
		if(user!=null)throw new UserException("用户已被注册");
		
		user=userDao.findByEmail(form.getEmail());
		if(user!=null)throw new UserException("邮箱已被注册");
		
		userDao.add(form);
	}
	public void active(String code) throws UserException
	{
		User user=userDao.findByCode(code);
		if(user==null)throw new UserException("激活码无效");
		if(user.getState()==1)throw new UserException("用户已经激活过了，不要重复操作");
		userDao.updateState(user.getUid(), 1);
	}
	public User login(User form) throws UserException
	{
		User user=userDao.findByUsername(form.getUsername());
		if(user==null)throw new UserException("用户不存在");
		if(!user.getPassword().equals(form.getPassword())) {
			throw new UserException("密码错误");
		}
		if(user.getState()==0)throw new UserException("用户还未激活");
		return user;
	}
	public Admin adminLogin(Admin admin) throws AdminException {
		Admin ad=userDao.adminLogin(admin);
		if(ad==null)throw new AdminException("管理员不存在");
		if(!ad.getPassword().equals(admin.getPassword()))
			throw new AdminException("管理员密码错误");
		return ad;
	}
}
