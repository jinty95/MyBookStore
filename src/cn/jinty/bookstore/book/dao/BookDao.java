package cn.jinty.bookstore.book.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.jinty.bookstore.book.domain.Book;
import cn.jinty.bookstore.category.domain.Category;

public class BookDao {
	private QueryRunner qr=new TxQueryRunner();
	public List<Book> findAll(){
		String sql="select * from book where del=false";
		try {
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Book> findByCategory(String cid){
		String sql="select * from book where cid=? and del=false";
		try {
			return qr.query(sql, new BeanListHandler<Book>(Book.class),cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Book loadBook(String bid) {
		String sql="select * from book where bid=?";
		try {
			Map<String,Object> map= qr.query(sql, new MapHandler(),bid);
			Category category=CommonUtils.toBean(map, Category.class);
			Book book=CommonUtils.toBean(map, Book.class);
			book.setCategory(category);
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int getCountByCid(String cid) {
		// TODO Auto-generated method stub
		String sql="select count(*) from book where cid=?";
		Number cnt;
		try {
			cnt = (Number)qr.query(sql, new ScalarHandler(),cid);
			return cnt.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	public void add(Book book) {
		// TODO Auto-generated method stub
		String sql="insert into book values(?,?,?,?,?,?,?,?,?)";
		Object params[]= {book.getBid(),book.getBname(),book.getPrice(),book.getImage(),book.getCategory().getCid(),book.getAuthor(),book.getVersion(),book.getPublish(),book.isDel()}; 
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(String bid) {
		String sql="update book set del=true where bid=?";
		try {
			qr.update(sql, bid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Book book) {
		// TODO Auto-generated method stub
		String sql="update book set bname=?,price=?,cid=?,author=?,version=?,publish=? where bid=?";
		Object[] params= {book.getBname(),book.getPrice(),book.getCategory().getCid(),book.getAuthor(),book.getVersion(),book.getPublish(),book.getBid()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
