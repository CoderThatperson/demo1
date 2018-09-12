package com.aaa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.dao.ICarDAO;
import com.aaa.dao.impl.CarDAOImpl;
import com.aaa.vo.Car;
import com.aaa.vo.User;
import com.alibaba.fastjson.JSON;
/**      Json   map
 *       传统模式                                                                            |      Ajax
 * 情景        绝对跳转                                                                                              只要不动
 *    
 * 请求        <a href=""></a>   get                    $.post()  $.get()    $.ajax()
 *       <form action=""  /> get post
 *       地址栏                                    get
 *       window.location.href get
 *       
 * 响应       请求转发   重定向 （都会返回一个新界面）                                	resp.setContentType("text/json;charset=UTF-8");
		
		                                            PrintWriter writer = resp.getWriter();
		
		                                            Map<Object,Object> map = new HashMap<>();
		                                            map.put("msg", "添加成功");
		
		                                            String json = JSON.toJSONString(map);
		
		                                            writer.write(json);       
 * 
 * 
 * 
 * 
 * 
 * 
 */
@WebServlet("/addgoods.do")
public class AddGoodsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static ICarDAO dao = new CarDAOImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String pid = req.getParameter("pid");
		String pname = req.getParameter("pname");
		String price = req.getParameter("price");
		String pimage = req.getParameter("pimage");
		String num = req.getParameter("num");
		
		User u = (User)req.getSession().getAttribute("User");
		
		Car c = new Car(0, u.getUid(), pid, pname, pimage, price, num);
		
		dao.insert(c);
		
		resp.setContentType("text/json;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		Map<Object,Object> map = new HashMap<>();
		map.put("msg", "添加成功");
		
		String json = JSON.toJSONString(map);
		
		writer.write(json);
	}

}









