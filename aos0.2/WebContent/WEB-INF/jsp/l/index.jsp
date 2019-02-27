<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1></h1>
		<nav class="navbar navbar-inverse">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar-menu"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>
		<div id="navbar-menu" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">油量显示</a></li>
				<li><a href="./Public"
					onclick="window.opener=null;window.close()">退出</a></li>
			</ul>
		</div>
		</nav>
		<div id="content" class="row-fluid">
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8"
						style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>油名</th>
									<th>剩余油量</th>
									<th>油价</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="stu">
									<tr>
										<td>${stu.id}</td>
										<td>${stu.oilname}</td>
										<td>${stu.leavecnt}</td>
										<td>${stu.price}</td>
										<td><a
											href="${pageContext.request.contextPath }/oilfindByid2.action?id=${stu.id}">加油</a></td>
										<td><a
											href="${pageContext.request.contextPath }/oilfindByid.action?id=${stu.id}">添加</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-2">
				<h2>注意事项</h2>
				<ul class="nav nav-tabs nav-stacked">
					<li><a href='#'>易燃物品</a></li>
					<li><a href='#'>严禁明火 2</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>