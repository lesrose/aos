<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>加油站油罐油量计量标定管理系统</title>
<link rel="stylesheet" href="css/public1.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>加油站油罐油量计量标定管理系统</h1>
	<div class="publicHeaderR">
		<p>
			<span id="hours"></span><span style="color: #fff21b"> ${uname}</span>
			欢迎你！
		</p>
		<a href="${pageContext.request.contextPath }/welcome1.action">退出</a> <br>
	</div>
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2018年6月18日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
		<nav>
		<ul class="list">
			<li><a href="./message">信息发布</a></li>
			<li><a href="#" id="active">文件操作</a></li>
			<li><a href="./Public">返回主页面</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>信息管理>>文件操作页面</span>
		</div>
		<div class="search">
			<table class="providerTable" cellpadding="0" cellspacing="0">
				<c:forEach items="${opfile}" var="item">
					<tr>
						<td>${item.id+1}</td>
						<td>${item.filename}</td>
						<td><a
							href="${pageContext.request.contextPath }/download.action?id=${item.id}">下载</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</section>
	<footer class="footer"> </footer>
	<script src="js/time.js"></script>
</body>
</html>