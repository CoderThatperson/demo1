<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册 - 贵美·商城</title>
		<base href="<%=basePath%>">
     	<link rel="icon" href="img/icon.png" type="image/x-icon">
		<link rel="stylesheet" type="text/css" href="css/register.css"/>
	</head>
	<body>
		
		<div class="wrap">
			<a href="/shop/home"><div class="guimeilogo"></div></a>
			<div class="register">
			
			
				<div class="top">
					<h1>新用户注册</h1>
					<a href="login.jsp">已有账号</a>
				</div>
				<div style="color:red">${error}</div>
				
				<div class="mid">
					<form action="/shop/reg" method="post">
					
					
					<input type="text" name="telephone" id="telephone" placeholder="手机号" required="required"/>
					
					<div class="sec">
					    
						<input type="text" name="code" id="code" placeholder="验证码" required="required" />
					
					    <a  class="send" onclick="send()"> 发送验证码 </a>
					    
					    <script>
					        function send(){
					              
					             return false;
					        }
					    </script>
					</div> 
					
					<input type="password" name="password" id="password" placeholder="密码" required="required" />
					
					<input type="password" name="reppw" id="reppw" placeholder="重复密码" required="required" />
				
					<input type="text" name="username" id="username" placeholder="亲，您的昵称" required="required" />
					
					<input type="submit" id="submit" value="注册"/>
					
				    </form>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
		    
		     if( '${success}'){
		          if( confirm("注册成功是否去登录") ){
		              window.location.href = "/shop/login.jsp";
		          }
		     }
		
		
		</script>
		
		
		
	</body>
</html>
