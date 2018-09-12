<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!DOCTYPE HTML>
<html>
  <head>
        <base href="<%=basePath%>">
     	<link rel="icon" href="img/icon.png" type="image/x-icon">
         <link rel="stylesheet" href="css/goodscart.css" />
	    <script type="text/javascript" src="js/product.js"></script>
	    
		<title>购物车 贵美·商城</title>
		
	</head>
	<body>
		  <!-- 头部导航 -->
		<jsp:include page="header.jsp"></jsp:include>
		
		<!-- 購物車 -->
		<div class="wrap">
			<div class="title">
				<ul>
				<li><input type="checkbox" name="" id="" value="" /> 全选</li>
				<li>商品</li>
				<li>商品信息</li>
				<li>单价（元）</li>
				<li>数量</li>
				<li>小计（元）</li>
				<li>操作</li>
			   </ul>
			</div>
			
			
			<div class="goods">
				<ul>
					<li><img src="img/1.jpg"/> 商品簡介</li>
					<li>尺碼:均碼</li>
					<li class="price">76</li>
					<li>
						<div class="count">
						
						<span class="s">－</span>
						<input type="text" value="1" name="num" class="num" />
						<span class="s">＋</span>
					    </div>
					
					</li>
					<li class="subtotal">76</li>
					<li>
						<a href="#">刪除</a>
					</li>
				</ul>
			</div>
			
			
			<div class="goods">
				<ul>
					<li><img src="img/1.jpg"/> 商品簡介</li>
					<li>尺碼:均碼</li>
					<li class="price">76</li>
					<li>
						<div class="count">
						
						<span class="s">－</span>
						<input type="text" value="1" name="num" class="num" />
						<span class="s">＋</span>
					    </div>
					
					</li>
					<li class="subtotal">76</li>
					<li>
						<a href="#">刪除</a>
					</li>
				</ul>
			</div>
			<div class="goods">
				<ul>
					<li><img src="img/1.jpg"/> 商品簡介</li>
					<li>尺碼:均碼</li>
					<li class="price">76</li>
					<li>
						<div class="count">
						
						<span class="s">－</span>
						<input type="text" value="1" name="num" class="num" />
						<span class="s">＋</span>
					    </div>
					
					</li>
					<li class="subtotal">76</li>
					<li>
						<a href="#">刪除</a>
					</li>
				</ul>
			</div>
			<div class="goods">
				<ul>
					<li><img src="img/1.jpg"/> 商品簡介</li>
					<li>尺碼:均碼</li>
					<li class="price">76</li>
					<li>
						<div class="count">
						
						<span class="s">－</span>
						<input type="text" value="1" name="num" class="num" />
						<span class="s">＋</span>
					    </div>
					
					</li>
					<li class="subtotal">76</li>
					<li>
						<a href="#">刪除</a>
					</li>
				</ul>
			</div>
			<div class="goods">
				<ul>
					<li><img src="img/1.jpg"/> 商品簡介</li>
					<li>尺碼:均碼</li>
					<li class="price">76</li>
					<li>
						<div class="count">
						
						<span class="s">－</span>
						<input type="text" value="1" name="num" class="num" />
						<span class="s">＋</span>
					    </div>
					
					</li>
					<li class="subtotal">76</li>
					<li>
						<a href="#">刪除</a>
					</li>
				</ul>
			</div>
			
			
			
			
			<div class="foot">
				<ul>
					<li><a href="#">全部刪除</a></li>
					<li>總價：￥<span style="color: red; font-size: 30px; font-weight: 600;" id="total">11111</span></li>
					<li><a href="#">去付款</a></li>
					
				</ul>
			</div>
			
		</div>
		
	</body>
</html>
