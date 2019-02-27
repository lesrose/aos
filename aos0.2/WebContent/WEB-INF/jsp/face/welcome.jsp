<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>加油站油罐油量计量标定管理系统</title>
</head>
<body>
	<p><marquee  bgcolor="purple" width="500" height="40" >
      <font color="white" size="6">加油站油罐油量计量标定管理系统</font>
      </marquee>
      </p>
      <form  method="post" action="${pageContext.request.contextPath }/login.action"> 
      用户名:<input type="text" name="uname" size="40"><br>
      密码:<input type="password" name="pwd" size="40"><br>
      <input type="submit" value="登录">
      </form>
</body>
</html>