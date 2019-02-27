<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加油罐数据</title>
</head>
<body>
<form id="autho1" action="${pageContext.request.contextPath }/addTankdataSubmit.action" method="post" >

<a href="${pageContext.request.contextPath }/addTankdataSubmit.action">添加</a>
添加油罐数据信息：
<table width="100%" border=1>


<tr>
	<td>油量高度</td>
	<td><input type="text" name="height"  /></td>
</tr>
<tr>
	<td>油量体积</td>
	<td><input type="text" name="volume" /></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>
</html>