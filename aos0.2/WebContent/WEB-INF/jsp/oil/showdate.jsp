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
	function check(form) {
		if (form.height.value == '') {
			alert("未输入 油高，请重新输入!");
			form.height.focus();
			return false;
		}
		if (form.type.value == '') {
			alert("未选择标定算法，请选择!");
			form.type.focus();
			return false;
		}
		document.myform.submit();
	}
</script>
<script language="javascript">
	function daoru(form) {
		if (form.myFile.value == '') {
			alert("未选择文件，请选择!");
			form.myFile.focus();
			return false;
		}
		document.myform1.submit();

	}
</script>
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>加油站油罐油量计量标定管理系统</h1>
	<div class="publicHeaderR">
		<p>
			<span id="hours"></span><span style="color: #fff21b"> ${uname
				}</span> 欢迎你！
		</p>
		<a href="${pageContext.request.contextPath }/welcome1.action">退出</a> <br>
	</div>
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2018年6月18日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<!-- <img alt="油罐数据图" src="img/test.jpg"> -->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
		<nav>
		<ul class="list">
			<li id="active"><a
				href="${pageContext.request.contextPath }/querytank.action">油罐查看</a></li>
			<li><a href="./stlist">加油站查看</a></li>
			<li><a href="./Public">返回上一级</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>油罐信息查看页面</span>
		</div>
		<div class="bd">
			<form action="${pageContext.request.contextPath }/select.action"
				name="myform" method="post">
				<div class="row">
					<span>标定油高：</span> <input type="text" id="1" name="height"
						placeholder="请输入实际测量油高"> <span>请选择标定算法：</span> <select
						name="type">
						<!--onchange="window.location=this.value;" -->
						<option value="">--请选择--</option>
						<option value="算法一">算法一</option>
						<option value="算法二">算法二</option>
						<option value="算法三">算法三</option>
					</select> <input type="button" name="submit1" value="标定"
						onclick="check(this.form)" />
				</div>
			</form>
			<div class="bd">
				<form action="${pageContext.request.contextPath }/import.action"
					method="post" enctype="multipart/form-data" name="myform1">
					<input type="file" name="myFile"> <input type="button"
						class="removeBill" onclick="daoru(this.form);" value="导入">
				</form>
			</div>
		</div>
		<span>数据列表：</span>
		<%-- action="${pageContext.request.contextPath }/item/queryItem.action" --%>
		<form
			action="${pageContext.request.contextPath }/deleteTankdataduo.action"
			
			method="post">
			<c:set var="d" value="${requestScope.d }" />
			<c:set var="perpage" value="${requestScope.perpage }" />
			<c:set var="pagecount" value="${requestScope.pagecount }" />
			<c:set var="beginindex" value="${requestScope.beginindex }" />
			<c:set var="endindex" value="${requestScope.endindex }" />
			<%-- <c:set var="page" value="1"/>
				 --%>
			<%-- <c:set var="dataList" value="${requestScope.dataList.subList((page-1)*perpage,(page-1)*perpage+perpage)}"/>
				 --%>


			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tr class="firstTr">
					<td>编号</td>
					<td>油量高度</td>
					<td>油量体积</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${dataList}" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.height }</td>
						<td>${item.volume }</td>
						<td><a
							href="${pageContext.request.contextPath }/uptankdate.action?id=${item.id}"><img
								src="img/xiugai.png" alt="修改" title="修改" /></a> <a
							href="${pageContext.request.contextPath }/deleteTankdata.action?id=${item.id}"><img
								src="img/schu.png" alt="删除" title="删除" /></a>
								<input type="checkbox" name="deleteduo" value=${item.id } >${item.id }删除</td>
						
					</tr>
				</c:forEach>
			</table>
			${e}
			</br>
			<div class="rows">
				<span> 第${page1}页 共${pagecount}页 ${beginindex} ${endindex}
					${d}</span> <a
					href="${pageContext.request.contextPath }/showdata.action?id=${id}&&page=${page1+1}">下一页</a>
				<a
					href="${pageContext.request.contextPath }/showdata.action?id=${id}&&page=${page1-1}">上一页</a>
					<input type="submit" value="批量删除"  style="position: absolute;right: 40px;width: 100px;height: 50px;" >
		</form>
		<a href="${pageContext.request.contextPath }/addTankdata.action">添加数据</a>
		<a href="${pageContext.request.contextPath }/picmake.action">生成图片</a>
		<a href="${pageContext.request.contextPath }/deleteTankdataduo.action" style="position: absolute;right: 240px;">批量删除</a>
		<!-- <input type="submit" value="删除"  style="position: absolute;right: 40px;width: 100px;height: 50px;"> -->
	</div>
	<footer class="footer"> </footer> <script src="js/time.js"></script> <script
		src="js/jquery.js"></script> <script src="js/jquery.js"></script>
</body>
</html>