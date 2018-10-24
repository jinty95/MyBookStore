package cn.jinty.bookstore.book.admin.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.CommonDataSource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;
import cn.jinty.bookstore.book.domain.Book;
import cn.jinty.bookstore.book.service.BookService;
import cn.jinty.bookstore.category.domain.Category;

public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");					//设置请求编码
		response.setContentType("text/html;charset=utf-8");		//设置响应编码
		//表单中存在文件上传时的数据处理方式
		DiskFileItemFactory factory=new DiskFileItemFactory(); 	//第一步：创建工厂对象
		ServletFileUpload sfu=new ServletFileUpload(factory);  	//第二步：创建上传对象
		try {
			List<FileItem> fil=sfu.parseRequest(request);	  	//第三步：解析请求获取FileItem
			Map<String,String> map=new HashMap<String,String>();
			for(FileItem fi:fil) {								//遍历由FileItem组成的集合
				if(fi.isFormField()) {							//如果FileItem是普通表单项，加入Map中
					map.put(fi.getFieldName(),fi.getString("UTF-8"));			
				}
			}
			String cid=map.get("cid");
			Category category=new Category();
			category.setCid(cid);
			Book book=CommonUtils.toBean(map, Book.class);		//用Map生成Book对象，保存普通数据
			book.setCategory(category);
		//保存上传的文件
		String path=this.getServletContext().getRealPath("/Image");		//获取项目的文件存放目录
		String fileName=CommonUtils.uuid()+"_"+fil.get(0).getName();	//得到上传的文件的名称(加uuid前缀)
		File destFile=new File(path,fileName);							//构建文件的保存路径
		fil.get(0).write(destFile);										//将上传的文件保存到项目中
		book.setImage("/Image/"+fileName);								//完善Book的image属性
		//调用BookService层的方法完成添加操作
		book.setBid(CommonUtils.uuid());
		bs.add(book);
		request.setAttribute("msg", "添加成功");  						//回馈添加完成的信息
		request.getRequestDispatcher("/AdminJSPS/Admin/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();										//打印捕捉到的异常
		}
	}

}
