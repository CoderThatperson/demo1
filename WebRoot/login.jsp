<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
		<title>登录 - 贵美·商城</title>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
	</head>
	<body>
		
		<div class="wrap">
			<div class="guimeilogo"></div>
			
			<div class="login">
			
				<div class="top">
					<h1>贵美商城</h1>
					<a href="register.jsp">新用户注册</a>
				</div>
				
				<div class="mid">
			
				       <div id="msg" style="color:red;display: none">用户名或密码错误</div>

					
					  <input type="text" name="telephone" id="telephone" placeholder="手机号" required="required" />
					  <input type="password" name="password" id="password" placeholder="密码" required="required" />
					  <input type="button" id="submit" value="立即登录"/>
				     <script type="text/javascript">
				         $("#submit").click(function(){
				               
				               $.post("/shop/login",{
				                 "telephone":$("#telephone").val(),
				                 "password":$("#password").val()
				               },function(data){
				                  if(data.msg == 0){
				                     $("#msg").css("display","block");
				                  }else{
				                      window.location.href ="/shop/home";
				                  }
				               });
				         
				         });
				     </script>
				</div>
				
			</div>
			
		</div>
	</body>
</html>
