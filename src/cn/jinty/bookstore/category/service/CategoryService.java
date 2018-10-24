package cn.jinty.bookstore.category.service;

import java.util.List;

import cn.jinty.bookstore.book.dao.BookDao;
import cn.jinty.bookstore.category.admin.servlet.CategoryException;
import cn.jinty.bookstore.category.dao.CategoryDao;
import cn.jinty.bookstore.category.domain.Category;

public class CategoryService {
	private CategoryDao cd=new CategoryDao();
	private BookDao bd=new BookDao();
	public List<Category> findAll()
	{
		return cd.findAll();
	}
	public void add(Category c) {
		cd.add(c);
	}
	public void delete(String cid) throws CategoryException {
		int count=bd.getCountByCid(cid);
		if(count>0)throw new CategoryException("该类不可以删除");
		cd.delete(cid);
	}
	public Category load(String cid) {
		return cd.load(cid);
	}
	public void edit(Category category) {
		// TODO Auto-generated method stub
		cd.edit(category);
	}
}
