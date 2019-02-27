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
<script type="text/javascript">
	function check() {
		var ge=confirm("是否确定修改？");
		if (ge==true) {
			return true;
		} else{
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
			<li><a href="#" id="active">信息发布</a></li>
			<li><a href="./upfile">文件操作</a></li>
			<li><a href="./Public">返回主页面</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>信息发布>>发布信息修改页面</span>
		</div>
		<div class="providerAdd">
			<form
				action="${pageContext.request.contextPath }/articleupdate.action"
				method="post" onsubmit="return check()">
				<!--div的class 为error是验证错误，ok是验证成功-->
				<!--<div class="">
                    <label for="oilId">序号：</label>
                    <input type="text" name="id" id="id" required/>
                    <span>*请输入信息序号: </span>
                </div>
                <div>
                    <label for="oilName">发布者名称：</label>
                    <input type="text" name="name" id="name" required/>
                    <span >*请输入发布者名称：</span>
                </div>
                -->
				<div>
					<label for="oilCom">发布信息：</label>
					<textarea name="lytext" cols="60" rows="12" id="lytext"></textarea>
					<span>*请输入修改后的信息</span>
				</div>
				<!-- <div>
                    <label for="oilNum">商品数量：</label>
                    <input type="text" name="oilNum" id="oilNum" required/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>-->
				<div class="providerAddBtn">
					<!--<a href="#">保存</a>-->
					<!--<a href="oilList.html">返回</a>-->
					<input type="submit" value="确定"  /> 
					<input type="button" value="返回" onclick="history.back(-1)" />
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