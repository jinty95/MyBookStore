package cn.jinty.bookstore.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.jinty.bookstore.user.domain.Admin;
import cn.jinty.bookstore.user.domain.User;

public class UserDao {
	private QueryRunner qr=new TxQueryRunner();
	public User findByUsername(String username) {
		String sql="select * from user where username=?";
		try {
			return (User) qr.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public User findByEmail(String email)
	{
		String sql="select * from user where email=?";
		try {
			return (User) qr.query(sql, new BeanHandler<User>(User.class), email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void add(User user)
	{
		String sql="insert into user values(?,?,?,?,?,?)";
		try {
			Object[] params= {user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCode(),user.getState()};
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public User findByCode(String code)
	{
		String sql="select * from user where code=?";
		try {
			return (User) qr.query(sql, new BeanHandler<User>(User.class), code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateState(String uid,int state)
	{
		String sql="update user set state=? where uid=?";
		try {
			qr.update(sql,state,uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Admin adminLogin(Admin admin) {
		String sql="select * from admin where aname=?";
		try {
			return qr.query(sql, new BeanHandler<Admin>(Admin.class),admin.getAname());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
