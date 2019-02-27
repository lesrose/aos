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
	function shanchu() {
		if (confirm("确定删除么？？")) {
			return true;
		} else {
			return false;
		}

	}
</script>
<script language="javascript">
	function chaxun(form) {
		if (form.uname.value == '') {
			alert("未输入用户名，请输入！！！");
			form.uname.focus();
			return false;
		}
		document.myform.submit();

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
			<!--<li><a href="billList.html">油罐信息</a></li>
                    <li><a href="providerList.html"></a></li>-->
			<li id="active"><a
				href="${pageContext.request.contextPath }/userlist.action">用户管理</a></li>
			<li><a href="${pageContext.request.contextPath }/Public">返回上一级</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>用户管理页面</span>
		</div>
		<div class="search">
			<form action="${pageContext.request.contextPath }/userselect.action"
				method="post" name="myform">
				<span>用户名：</span> <input type="text" name="uname"
					placeholder="请输入用户名" /> <input type="button" name="submit1"
					onclick="chaxun(this.form)" value="查询" />
			</form>
			<a href="./useradd">添加用户</a>
		</div>
		<!--用户-->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr class="firstTr">
				<th width="10%">用户编码</th>
				<th width="10%">用户名称</th>
				<th width="10%">用户密码</th>
				<th width="10%">年龄</th>
				<th width="10%">性别</th>
				<th width="10%">电话</th>
				<th width="10%">用户类型</th>
				<th width="10%">所属加油站</th>
				<th width="10%">所属地</th>
				<th width="30%">操作</th>
			</tr>
			<c:forEach items="${listall}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.uname }</td>
					<td>${user.password}</td>
					<td>${user.age}</td>
					<td>${user.sex}</td>
					<td>${user.phonenumber }</td>
					<td>${user.roleplay }</td>
					<td>${user.athority}</td>
					<td>${user.pro}</td>
					<td><a
						href="${pageContext.request.contextPath }/userupdate.action?id=${user.id }"><img
							src="img/xiugai.png" alt="修改" title="修改" /></a> <a
						href="${pageContext.request.contextPath }/userdelete.action?id=${user.id }"
						class="removeUser" onclick="return shanchu()"><img
							src="img/schu.png" alt="删除" title="删除" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
	</section>

	<footer class="footer"> </footer>
	<script src="js/time.js"></script>
	<script src="js/js.js"></script>
	<script src="js/jquery.js"></script>
</body>
</html>