<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>加油站油罐油量计量标定管理系统</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/public1.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script language="javascript">
	function tiao() {
		if (confirm("你是worker 么？？")) {
			return true;
		} else {
			alert('你不具有此权限');
			return false;
		}

	}
</script>
<script language="javascript">
	function shanchu() {
		if (confirm("确定删除么？？")) {
			return true;
		} else {
			return false;
		}

	}
</script>
<script language="javascript">
	function daochu() {
		if (confirm("确定导出么？？")) {
			return true;
		} else {
			return false;
		}

	}
</script>
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
			<li id="active"><a
				href="${pageContext.request.contextPath }/querytank.action">油罐查看</a></li>
			<li><a
				href="${pageContext.request.contextPath }/stlist.action">加油站查看</a></li>
			<li><a href="./Public">返回上一级</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>油罐信息页面</span>
		</div>
		<div class="search">
			<form action="" method="post">
				<a href="./oiladd">添加油罐</a>
			</form>
		</div>
		<!--账单表格 -->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr class="firstTr">
				<th width="10%">油罐编码</th>
				<th width="20%">加油站名称</th>
				<th width="10%">所在县</th>
				<th width="10%">所在市</th>
				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${autholist }" var="item">
				<tr>
					<td>${item.authority }</td>
					<td>${item.sname }</td>
					<td>${item.authority }</td>
					<td>${item.pro }</td>
					<td><a
						href="${pageContext.request.contextPath }/updatetank.action?id=${item.id} ">
							<img src="img/xiugai.png" alt="修改" title="修改" />
					</a> <a
						href="${pageContext.request.contextPath }/showdata.action?id=${item.id} ">
							<img src="img/read.png" alt="查看" title="查看" />
					</a> <a
						href="${pageContext.request.contextPath }/deletetank.action?id=${item.id}"
						class="removeBill" onclick="return shanchu();"> <img
							src="img/schu.png" alt="删除" title="删除" /></a> <a
						href="${pageContext.request.contextPath }/export.action?id=${item.id}"
						class="removeBill" onclick="return daochu();"> <img
							src="img/dc.png" alt="导出" title="导出" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</section>
	<footer class="footer"> </footer>
	<script src="js/time.js"></script>
	<script src="js/jquery.js"></script>
</body>
</html>