package com.aaa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.IProductDAO;
import com.aaa.dao.impl.ProductDAOImpl;
import com.aaa.vo.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private static IProductDAO dao = new ProductDAOImpl();
	/**
	 * 
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		int pid = 0;
		try{
			pid = Integer.parseInt(id);
		}catch(Exception e){
			System.out.println("ProductServlet -----------》id类型转换错误");
			req.setAttribute("msg", "请求参数有问题啊");
			req.getRequestDispatcher("product.jsp").forward(req, resp);
			return ;
		}
		
		Product product = dao.getProductByID(pid);
		
		if(product != null){
			req.setAttribute("p", product);
		}
		
		req.getRequestDispatcher("product.jsp").forward(req, resp);
		
	}

}








