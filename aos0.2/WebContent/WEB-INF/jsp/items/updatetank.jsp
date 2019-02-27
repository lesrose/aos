<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改油罐信息</title>

</head>
<body> 

<form id="autho1" action="${pageContext.request.contextPath }/updatetankSubmit.action" method="post" >
<%-- <input type="hidden" name="id" value="${itemsCustom.id }"/> --%>
<a href="${pageContext.request.contextPath }/updatetankSubmit.action">修改</a>
修改油罐信息：
<table width="100%" border=1>

<tr>
	<td>油罐名称</td>
	<td><input type="text" name="sname"  value="${autho.sname}"/></td>
</tr>
<tr>
	<td>所属级别</td>
	<td><input type="text" name="authority"  value="${autho.authority}"/></td>
</tr>
<tr>
	<td>所属市</td>
	<td><input type="text" name="pro" value="${autho.pro}" /></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>