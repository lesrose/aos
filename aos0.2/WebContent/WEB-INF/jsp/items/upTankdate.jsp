<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改油罐数据信息</title>

</head>
<body> 

<form id="autho1" action="${pageContext.request.contextPath }/uptankdateSubmit.action" method="post" >

<a href="${pageContext.request.contextPath }/uptankdateSubmit.action">修改</a>
修改信息：
<table width="100%" border=1>

<tr>
	<td>id</td>
	<td><input type="text" name="id"  readonly="readonly" value="${oiltank.id}"/></td>
</tr>
<tr>
	<td>油量高度</td>
	<td><input type="text" name="height"  value="${oiltank.height}"/></td>
</tr>
<tr>
	<td>油量体积</td>
	<td><input type="text" name="volume" value="${oiltank.volume}" /></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>