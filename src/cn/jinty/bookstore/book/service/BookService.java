package cn.jinty.bookstore.book.service;

import java.util.List;

import cn.jinty.bookstore.book.dao.BookDao;
import cn.jinty.bookstore.book.domain.Book;

public class BookService {
	private BookDao bd=new BookDao();
	public List<Book> findAll()
	{
		return bd.findAll();
	}
	public List<Book> findByCategory(String cid)
	{
		return bd.findByCategory(cid);
	}
	public Book loadBook(String bid)
	{
		return bd.loadBook(bid);
	}
	public void add(Book book) {
		// TODO Auto-generated method stub
		bd.add(book);
	}
	public void delete(String bid) {
		bd.delete(bid);
	}
	public void update(Book book) {
		// TODO Auto-generated method stub
		bd.update(book);
	}
}
