package com.aaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.IUserDAO;
import com.aaa.dao.impl.UserDAOImpl;
import com.aaa.vo.User;
import com.alibaba.fastjson.JSON;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static IUserDAO dao = new UserDAOImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String telephone = req.getParameter("telephone");
		String password = req.getParameter("password");
		
		User user = dao.login(telephone, password);
		
		resp.setContentType("text/json:charset=UTF-8");
		Writer writer = resp.getWriter();
		
		Map<Object,Object> map = new HashMap<>();
		if(user == null){
			map.put("msg", "0");
		}else{
			req.getSession().setAttribute("User", user);
			map.put("msg", "1");
		}
		
		writer.write(JSON.toJSONString(map));
	}
}











