<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>油罐数据</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
<c:set var="d" value="${requestScope.d }"/>
<c:set var="perpage" value="${requestScope.perpage }"/>
<c:set var="pagecount" value="${requestScope.pagecount }"/>
<c:set var="beginindex" value="${requestScope.beginindex }"/>
<c:set var="endindex" value="${requestScope.endindex }"/>
<%-- <c:set var="page" value="1"/>
 --%>
 <%-- <c:set var="dataList" value="${requestScope.dataList.subList((page-1)*perpage,(page-1)*perpage+perpage)}"/>
 --%>数据列表：
<table width="100%" border=1>
<tr>
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
	<td><a href="${pageContext.request.contextPath }/uptankdate.action?id=${item.id}">修改</a></td>
	<td><a href="${pageContext.request.contextPath }/deleteTankdata.action?id=${item.id}">删除</a></td>
</tr>
</c:forEach>
</table>
 第${page1}页 共${pagecount}页
${beginindex} ${endindex}  ${d}
 <a href="${pageContext.request.contextPath }/showdata.action?id=${id}&&page=${page1+1}">下一页</a>
 <a href="${pageContext.request.contextPath }/showdata.action?id=${id}&&page=${page1-1}">上一页</a>
</form>
<a href="${pageContext.request.contextPath }/addTankdata.action">添加数据</a>
<a href="${pageContext.request.contextPath }/picmake.action">生成图片</a>
</body>

</html>