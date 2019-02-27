<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
</head>
<body>
<h3>文件下载</h3>
<table align="center" width="100%" border=1>
<c:forEach items="${opfile}" var="item">
<tr>
	<td>${item.id+1}</td>
	<td>${item.filename}</td>	
	<td><a href="${pageContext.request.contextPath }/download.action?id=${item.id}">下载</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>