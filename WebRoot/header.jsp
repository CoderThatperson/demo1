<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"views/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

	<link rel="stylesheet" type="text/css" href="css/header.css"/>
        <!--头部-->
 
 
		<div class="header_wrap">			
			<ul>
			   <c:choose>
			       <c:when test="${empty User}">
			           <li><a href="login.jsp">登录</a></li>
				       <li><a href="register.jsp">注册</a></li>
			       </c:when>
			       <c:otherwise>
			           <li>欢迎VIP:<a href="">${User.username}</a></li>
			       </c:otherwise>
			   
			   </c:choose>
				
				<li><a href="#">我的收藏</a></li>
				<li><a href="/shop/usercar.do">我的购物车</a></li>
				<li><a href="#">我的订单</a></li>
				<li><a href="#">帮助中心</a></li>
				<li><a href="#">商家后台</a></li>
				
			</ul>
		</div>
		