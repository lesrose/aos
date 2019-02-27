<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询油罐列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/querytank.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
油罐列表：
<table width="100%" border=1>
<tr>	
	<td>名称</td>			
</tr>
<c:forEach items="${autholist }" var="item">
<tr>
	
	<td>${item.sname }</td>
	
	
	<td><a href="${pageContext.request.contextPath }/showdata.action?id=${item.id}">查看</a></td>
	<td><a href="${pageContext.request.contextPath }/updatetank.action?id=${item.id}">修改</a></td>
	<td><a href="${pageContext.request.contextPath }/deletetank.action?id=${item.id}">删除</a></td>

</tr>
</c:forEach>

</table>
<a href="${pageContext.request.contextPath }/addtank.action">添加</a>
<a href=" ${pageContext.request.contextPath }/upfile.action">上传文件</a>
<a href=" ${pageContext.request.contextPath }/downfile.action">下载文件</a>
</form>
</body>

</html>