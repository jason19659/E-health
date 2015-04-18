<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<title>register lingmengfood beta</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="shortcut icon" href="assets/img/favicon.ico" />
<link rel="shortcut icon" href="images/favicon.ico" />

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/slider.css">
<link rel="stylesheet" href="css/zerogrid.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/responsive.css" type="text/css"
	media="screen">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>

<body>
	<div class="main">
		<header>
			<div class="zerogrid">
				<div class="col-full">
					<div class="wrap-col">
						<h1>
							<a href="index.html"><img src="images/logo.png"
								alt="EXTERIOR"></a>
						</h1>

						<div class="menu_block">
							<nav>
								<ul class="sf-menu">
									<li class="current"><a href="<%=basePath%>">主页</a></li>
									<li><a href="<%=basePath%>gwc">购物车</a></li>
									<li><a href="<%=basePath%>menu">菜单</a></li>

									<li><a href="<%=basePath%>login">登录</a></li>
								</ul>
							</nav>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</header>

		<div class="register-container container">
			<div class="row">
				<div class="iphone span5">
					<img src="images/page1_img1.jpg" alt="">
				</div>
				<div class="register span6">
					<form action="register" method="post">
						<h2>
							注册<span class="red"><strong> 灵梦订餐<font
									color="#00FF00"> beta</font>
							</strong></span>
						</h2>
						<labe for="username">用户名</label> <input type="text" id="firstname"
							name="username" placeholder="请输入用户不能少于6位名"
							onblur="checkUsername();"> <label id="usermsg"></label> <label
							for="password">密码</label> <input type="password" id="password"
							name="password" placeholder="不能少于6位."> <label
							for="repassword">确认密码</label> <input type="password"
							id="password" name="repassword" placeholder="请与密码相同"> <label
							for="phone">手机号码</label> <input type="text" id="lastname"
							name="phone" placeholder="找回密码必备"> <label for="email">Email</label>
						<input type="text" id="email" name="email" placeholder="电子邮件">
						<label for="username">地址</label> <input type="text" id="firstname"
							name="address" placeholder="地址">
						<button type="submit">注册</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div class="zerogrid">
			<div class="col-full">
				<div class="wrap-col">
					&copy; Copyright &copy; 2014.<a href="mailto:jason19659@163.com">jason</a>
					All rights reserved.
				</div>
			</div>
	</footer>
	<!-- Javascript -->
	<script src="assets/js/jquery-1.8.2.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>
	<script>
		function checkUsername() {
			var username;
			username = document.getElementById('firstname').value;
			if (username.length < 6) {
				document.getElementById("usermsg").innerHTML = '<span style="color:red;font-size:16px;">用户名长度不够!</span>';
			} else {
				var xmlhttp;
				if (window.ActiveXObject) {
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				} else if (window.XMLHttpRequest) {
					xmlhttp = new XMLHttpRequest();
				}
				if (xmlhttp) {
					xmlhttp.onreadystatechange = function() {
						if (xmlhttp.readyState == 4) {
							if (xmlhttp.status == 200) {
								var RequestTxt = unescape(xmlhttp.responseText);
								document.getElementById("usermsg").innerHTML = '<span style="color:red;font-size:16px;">'+RequestTxt+'</span>';
							}
						} else {
							document.getElementById("usermsg").innerHTML = '正在查找...';
						}
					}
					xmlhttp.open("get", "api/user/usercheck?username="+username, true);
					xmlhttp.send("test.asp");
				}
			}
		}
	</script>
	<div style="display:none"></div>
</body>
</html>