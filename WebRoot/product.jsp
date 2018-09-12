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
    
    <meta charset="UTF-8">
		<title>商品详情</title>
		<link rel="stylesheet" type="text/css" href="css/product.css"/>
		<script type="text/javascript" src="js/product.js">
			
		</script>

      <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
  
  </head>
  
  <body>
	   <!-- 头部导航 -->
		<jsp:include page="header.jsp"></jsp:include>
        <c:choose>
            <c:when test="${empty p}">
                                              对不起暂无该商品
            </c:when>
            <c:otherwise>
                
			<div class="wrap">
			<img src="${p.pimage}" />
			<div class="description">

				<form action="/shop/addgoods.do" method="post">
					<h2>${p.pname}</h2>
					<div class="old_price">
						原价：
						<span>
				    	￥${p.marketPrice}
				    </span>
					</div>
					<div class="price">
						折扣价：
						<span>
				    	￥${p.shopPrice}
				    </span>
					</div>

					<div>
						尺码：均码
					</div>

					<div class="count">
						数量：
						<span class="s">－</span>
						<input type="text" value="1" id="num" name="num" class="num" />
						<span class="s">＋</span>
					</div>
					
					<%-- <input type="hidden" name="id" value="${p.pid}"          />
					<input type="hidden" name="pname" value="${p.pname}"      />
					<input type="hidden" name="price" value="${p.shopPrice}"  />
					<input type="hidden" name="pimage" value="${p.pimage}"    /> --%>
					
					
					<div>
						<input type="button" id="addBtn" value="加入购物车" class="goods_cart" />
					</div>
					
					<div>
						<input type="submit" value="立即购买" class="buy"/>
					</div>
				</form>
			</div>

		</div>
            
            
            </c:otherwise>
        
        
        </c:choose>
        
        <script type="text/javascript" >
            $("#addBtn").click(function(){
                $.post("/shop/addgoods.do",{
                     "pid":'${p.pid}',
                     "pname":'${p.pname}',
                     "price":'${p.shopPrice}',
                     "pimage":'${p.pimage}',             //el
                     "num":$("#num").val()               //jq
                },function(data){
                    if( confirm(data["msg"])){
                       window.location.href="/shop/usercar.do";
                    }
                });
            });
        </script>
	
	</body>

</html>
