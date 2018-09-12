package com.aaa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.IProductDAO;
import com.aaa.dao.impl.ProductDAOImpl;
import com.aaa.vo.Product;
/**
 *  首页
 *  /shop
 *  /home
 * @author Administrator
 *
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private static IProductDAO dao = new ProductDAOImpl();
	/**
	 * 1 调用dao 获取 所有的商品信息
	 * 2 请求共享到 jsp
	 * 3 请求转发到index.jsp 展示数据
	 * 
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Product> all = dao.getAll();
		
		req.setAttribute("all", all);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}






