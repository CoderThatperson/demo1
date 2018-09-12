package com.aaa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.IUserDAO;
import com.aaa.dao.impl.UserDAOImpl;
import com.aaa.vo.User;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static IUserDAO dao = new UserDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String telephone = req.getParameter("telephone");//账号
		String password = req.getParameter("password");  //密码
		String username = req.getParameter("username");  //昵称
		
		User user = new User(0, username, password, null, telephone);
		
		boolean exist = dao.isExist(telephone);
		
		if(exist){
			req.setAttribute("error", "改手机号已被占用");
		}else{
			dao.insert(user);
			req.setAttribute("success", "注册成功");
		}
		req.getRequestDispatcher("register.jsp").forward(req, resp);
	}

}







