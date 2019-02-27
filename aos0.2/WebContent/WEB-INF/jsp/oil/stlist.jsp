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
<script type="text/javascript" src="js/jquery.min.js"></script>
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
			<li><a href="./oillist">油罐查看</a></li>
			<li id="active"><a
				href="${pageContext.request.contextPath }/stlist.action">加油站查看</a></li>
			<!--<li><a href="providerList.html"></a></li>
                    <li><a href="${pageContext.request.contextPath }/userlist">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath }/password">密码修改</a></li>-->
			<li><a href="./Public">返回上一级</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>信息管理>>加油站信息页面</span>
		</div>
		<div class="search">
			<form action="" method="post">
				<a href="./addstation">新建加油站</a>
			</form>
		</div>
		<table class="providerTable" cellpadding="0" cellspacing="0">

			<tr class="firstTr">

				<th width="20%">加油站名称</th>

				<th width="20%">操作</th>
			</tr>
			<c:forEach items="${b}" var="item" varStatus="id">
				<tr>
					<td>${id.index+1} ${item}</td>
					
					<td><a
						href="${pageContext.request.contextPath }/tanklist.action?id=${id.index}"><img
							src="img/read.png" alt="查看" title="查看" /></a></td>
				</tr>
			</c:forEach>

		</table>
		<!--账单表格 -->

	</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<footer class="footer"> </footer>

	<script src="js/time.js"></script>
	<script src="js/js.js"></script>
	<script src="js/jquery.js"></script>
</body>
</html>