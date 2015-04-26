<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link rel="shortcut icon" href="images/favicon.ico" />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="css/jquery.countdown.css" />
<!-- Custom Theme files -->
<!--webfont-->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- dropdown -->
<script src="js/fuc.js"></script>
<script src="js/jquery.easydropdown.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>

<script src="js/responsiveslides.min.js"></script>
<link rel="stylesheet" href="assets/css/style.css">

<script src="js/jquery.countdown.js"></script>
<script src="js/script.js"></script>
<script src="js/indexLoad.js"></script>
</head>
<body>
	<div class="header_top">
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="logo span4">
						<h1>
							<a href="" onclick="getPath('/index.htnl')">E-Health<span class="red">.</span></a>
						</h1>
					</div>
					<div class="links span8">
						<a class="home" href="#" onclick="jumpTo('/index.html')"
							rel="tooltip" data-placement="bottom" data-original-title="主页"></a>
						<a class="menu" href="#" onclick="jumpTo('/menu.html')"
							rel="tooltip" data-placement="bottom" data-original-title="菜单"></a>
						<a class="login" href="#" onclick="jumpTo('/login.html')"
							rel="tooltip" data-placement="bottom" data-original-title="登录"></a>
						<a class="register" href="#" onclick="jumpTo('/register.html')"
							rel="tooltip" data-placement="bottom" data-original-title="注册"></a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="main">
		<!--==============================header=================================-->
		<header>
			<div class="zerogrid">
				${user.username == null ? '' : '欢迎,'} ${user.username == null ? '' : user.username}
				</div>
				
		</header>
		<body>
			<c:if test="${isLogin == null }">
				<jsp:forward page="login.html"></jsp:forward>
			</c:if>
			<c:if test="${gwc == null }">
	您的购物车是空的
　　	</c:if>
			<c:if test="${gwc != null }">
			
				<c:forEach var="item" items="${gwc}">
				<form action="api/order/preSubmitOrder" method="post" >
				${item.name}<input name="id" type=hidden value="${item.id}">
   					 , ${item.price}元,
   				 <input name="amount" type=text value="${item.amount}" size=2> 个
   				 <input type="submit" name="button" value="删除"><input type="submit" name="button" value="确认">
   					 </form>
		</c:forEach>
		<form action="api/order/submitOrder" method="post" >
		地址:<input type="text" name="address" value="${user.address} ">
		<input type="submit" name="button" value="提交订单">
		</form>
			</c:if>
			<footer>
				<div class="zerogrid">
					<div class="col-full">
						<div class="wrap-col">
							&copy; Copyright &copy; 2014.<a href="mailto:jason19659@163.com">jason</a>
							All rights reserved.
						</div>
					</div>
			</footer>
		</body>
</html>
