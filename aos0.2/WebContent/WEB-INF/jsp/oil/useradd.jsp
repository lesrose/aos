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
	function tianjia() {
		if (confirm("确定添加么？？")) {
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
			<!--<li><a href="billList.html">油罐信息</a></li>
                    <li><a href="providerList.html"></a></li>-->
			<li id="active"><a
				href="${pageContext.request.contextPath }/userlist.action">用户管理</a></li>
			<li><a href="${pageContext.request.contextPath }/userlist">返回上一级</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>用户管理页面 >> 用户添加页面</span>
		</div>
		<div class="providerAdd">
			<form action="${pageContext.request.contextPath }/userinsert.action"
				method="post" onsubmit="return tianjia()">
				<!--div的class 为error是验证错误，ok是验证成功-->
				<div>
					<label for="userName">用户名称：</label> <input type="text" name="name"
						id="name" /> <span>*请输入用户名称</span>
				</div>
				<div>
					<label for="userpassword">用户密码：</label> <input type="text"
						name="pwd" id="pwd" /> <span>*密码长度必须大于6位小于20位</span>

				</div>
				<div>
					<label for="userRemi">确认密码：</label> <input type="text" name="pwd"
						id="pwd" /> <span>*请输入确认密码</span>
				</div>
				<div>
					<label for="userage">用户年龄：</label> <input type="text" name="age"
						id="age" />

				</div>
				<div>
					<label>用户性别：</label> <select name="type">
						<option value="男">男</option>
						<option value="女">女</option>
					</select> <span></span>
				</div>
				<div>
					<label for="userphone">用户电话：</label> <input type="text"
						name="phone" id="phone" /> <span>*</span>
				</div>
				<div>
					<label>用户类别：</label> <input type="radio" name="roleplay"
						value="admin" />管理员 <input type="radio" name="roleplay"
						value="boss" />站长 <input type="radio" name="roleplay"
						value="woker" />工作人员
				</div>
				<div>
					<label for="userphone">所属加油站：</label> <input type="text"
						name="athority" id="athority" /> <span>*</span>
				</div>
				<div>
					<label for="userphone">所属地：</label> <input type="text" name="pro"
						id="pro" /> <span>*</span>
				</div>
				<div class="providerAddBtn">
					<input type="submit" value="确定" /> <input type="button" value="返回"
						onclick="history.back(-1)" />
				</div>
			</form>
		</div>
	</div>
	</section>
	<footer class="footer"> </footer>
	<script src="js/time.js"></script>
	<script src="js/js.js"></script>
	<script src="js/jquery.js"></script>
</body>
</html>