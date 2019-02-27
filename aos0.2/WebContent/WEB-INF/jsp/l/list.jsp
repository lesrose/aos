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
<script type="text/javascript">
	function check(form) {
		var value = document.getElementById("inputId").value;
		var reg = /^\d+(\.\d+)?$/;
		if (form.s.value == '') {
			alert("未输入，请重新输入!");
			form.s.focus();
			return false;
		}
		if (reg.test(value) == false) {
			alert("输入格式有误，请重新输入 ");
			form.s.focus();
			return false;
		}

		document.myform.submit();
	}
</script>
<!-- function check(){
    var value = document.getElementById("inputId").value;
    var reg = /^\d+(\.\d+)?$/;  
    if(reg.test(value)==true){
        alert("全为数字，格式正确！通过");
        return true;
    }else{
        alert("格式有误！失败！");
        return false;
    }
    }-->

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
				<li class="active"><a href="#">加油</a></li>
				<li><a href="${pageContext.request.contextPath }/oilfinall.action">返回</a></li>
				<!--<li><a href="#" onclick="window.opener=null;window.close()" >退出</a></li>-->
			</ul>
		</div>
		</nav>
		<div id="content" class="row-fluid">
			<div class="col-md-10">
				<div class="row">
					<div class="col-md-9"
						style="box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
						<div class="row">.</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>油号</th>
									<th>油名</th>
									<th>剩余油量</th>
									<th>单价</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="s">
									<tr>
										<td>${s.id}</td>
										<td>${s.oilname}</td>
										<td>${s.leavecnt}</td>
										<td>${s.price}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<p>................................. ..................</p>
				</div>
				<div class="row">
					<form
						action="${pageContext.request.contextPath }/updateoilsell.action"
						name="myform" method="post" class="form-inline">
						<div class="form-group col-md-3">
							<label class="sr-only" for="name">油量</label> <input id="inputId"
								type="text" class="form-control" name="s" placeholder="请输入升数">
						</div>
						<button type="button" name="submit1"
							class="btn btn-success col-md-2" onclick="check(this.form);">提交</button>
					</form>
					<div class="form-group">
						<input type="button" class="btn btn-bg" data-toggle="modal"
							data-target="#myModal" value="生成发票">
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

	<div class="container">
		<!--  定义模态框触发器，此处为按钮触发  -->
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
						<h4>查看发票</h4>
						<!--  标题内容  -->
					</div>
					<div class="modal-body">
						<!--  模态框内容，我在此处添加一个表单 -->
						<form class="form-horizontal" role="form">
							<table class="table">
								<thead>
									<th>油号</th>
									<th>加油升数</th>
									<th>单价</th>
									<th>总计</th>
								</thead>
								<tbody>
								 <c:forEach items="${list}" var="s">
			<tr>
			           	<td>${s.id}</td>
			           	<td>${s.amount}</td>
				         <td>${s.price}</td>
				         <td>${s.toprice}</td>
			</tr>
			</c:forEach> 
			
								</tbody>
							</table>
							<div class="form-group">
								<label for="time" class="col-sm-2 control-label">当前时间 *</label>
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
						<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
		</div>
		<!-- /.modal -->
	</div>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>