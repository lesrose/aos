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
<form action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
数据列表：
<table width="100%" border=1>
<tr>
	<td>编号</td>
	<td>路径</td>
	<td>油罐名称</td>
	<td>加油站名</td>
	<td>权限等级</td>
	<td>操作</td>
</tr>
<c:forEach items="${pathList }" var="item">
<tr>
	<td>${item.id }</td>
	<td>${item.path }</td>
	<td>${item.tankname }</td>
	<td>${item.stationname }</td>
	<td>${item.power }</td>
	<td><a href="${pageContext.request.contextPath }/showdata.action?id=${item.id}">查看</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>