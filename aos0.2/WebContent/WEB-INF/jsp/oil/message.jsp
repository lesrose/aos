<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>加油站油罐油量计量标定管理系统</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/public1.css" />
<script language="javascript">
function gai() {
	if (confirm("确定修改么？？")) {
		return true;
	} else {
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
			<li><a href="${pageContext.request.contextPath }/showm.action">信息发布</a></li>
			<li><a href="${pageContext.request.contextPath }//upfile.action">文件操作</a></li>
			<li><a href="./Public">返回主页面</a></li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>信息管理>>信息发布页面</span>
		</div>
		<div class="clearfix"
			style="background: #D8D8D8; border: 1px solid #000; padding: 10px;">
			<div class="pull-left" style="background: #58D3F7;">发布信息显示</div>
		</div>
		<table class="table" cellpadding="0" cellspacing="0" border="1">
			<thead>
				<th width="10%">序号</th>
				<th width="15%">用户名</th>
				<th width="10%">发布信息</th>
				<th width="15%">联系方式</th>
				<th width="30%">操作</th>
			</thead>
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.r_id}</td>
					<td>${s.r_author}</td>
					<td>${s.r_summary}</td>
					<td>${s.r_date}</td>
					<td><a
						href="${pageContext.request.contextPath }/up.action?id=${s.r_id}"
						class="removeBill" onclick="return gai()"><img
							src="img/xiugai.png" alt="修改" title="修改" />修改</a> <a
						href="${pageContext.request.contextPath }/articledelete.action?id=${s.r_id}"
						class="removeBill" onclick="return shanchu()"><img
							src="img/schu.png" alt="删除" title="删除" />删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="search">
			<div>
				&nbsp;
				<button class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">添加发布信息</button>
			</div>
		</div>
		<div class="container">
			<!--  定义模态框触发器，此处为按钮触发  -->
			<form method="post"
				action="${pageContext.request.contextPath }/articleinsert.action"
				class="form-horizontal" role="form" id="myForm" onsubmit="return ">
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<!--  定义模态框，过渡效果为淡入，id为myModal,tabindex=-1可以禁用使用tab切换，aria-labelledby用于引用模态框的标题，aria-hidden=true保持模态框在触发前窗口不可见  -->
					<div class="modal-dialog">
						<!--  显示模态框对话框模型（若不写下一个div则没有颜色）  -->
						<div class="modal-content">
							<!--  显示模态框白色背景，所有内容都写在这个div里面  -->
							<div class="btn-info modal-header">
								<!--  模态框标题  -->
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<!--  关闭按钮  -->
								<h4>您好，欢迎发布信息</h4>
								<!--  标题内容  -->
							</div>
							<div class="modal-body">
								<!--  模态框内容，我在此处添加一个表单 -->
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<label for="uname" class=" col-sm-2 control-label">姓名
											*</label>
										<div class="col-sm-9">
											<input name="name" type="text" id="name" class="form-control"
												placeholder="请输入用户名" />
										</div>
									</div>
									<div class="form-group">
										<label for="uname" class=" col-sm-2 control-label">联系方式
											*</label>
										<div class="col-sm-9">
											<input name="phone" type="text" id="name"
												class="form-control" placeholder="请输入你的联系方式" />
										</div>
									</div>
									<div class="form-group">
										<label for="upta" class="col-sm-2 control-label">发布信息
											*</label>
										<div class="col-sm-9">
											<textarea name="lytext" cols="60" rows="12" id="lytext"></textarea>
											<!--<input type="textarea" id="upwd" name="upta" class="form-control " placeholder="请输入发布信息"/>-->
										</div>
									</div>

									<div class="form-group">
										<label for="time" class="col-sm-2 control-label">当前时间
											*</label>
										<div class="col-sm-9">
											<%=new java.sql.Timestamp(System.currentTimeMillis())
					.toString().substring(0, 10)%>
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<!--  模态框底部样式，一般是提交或者确定按钮 -->
								<button type="submit" class="btn btn-info">确定</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取消</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
				</div>
				<!-- /.modal -->
			</form>
		</div>
	</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<footer class="footer"> </footer>

	<script src="js/time.js"></script>
	<script src="js/jquery.js"></script>
	<!-- Bootstrap的所有插件都依赖于jQuery，必须在引入bootstrap.min.js前引入jQuery -->
	<script
		src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- 压缩版的bootstrap.min.js包含了所有的Bootstrap数据API插件 -->
	<script
		src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>