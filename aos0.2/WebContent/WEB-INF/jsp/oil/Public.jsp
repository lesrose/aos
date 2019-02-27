<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
    <meta charset="UTF-8">
    <title>加油站油罐油量计量标定管理系统</title>
    <link rel="stylesheet" href="css/public1.css"/>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
     <script language="javascript">
         function tiao(){
        if(confirm("你是Admin 么？？")){    
            return true;    
        }
        alert("你无此权限！！")   
        return false;
      }
      </script>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>加油站油罐油量计量标定管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${uname} </span> 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/welcome1.action">退出</a>
            <br>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2018年6月18日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
                <ul class="list">
                    <li ><a href="./oillist">油品计量</a></li>
                    <!--<li><a href="providerList.html">文件管理</a></li>-->
                    <li><a href="${pageContext.request.contextPath }/oilfinall.action">油品销售</a></li>
                    <li><a href="${pageContext.request.contextPath }/userlist.action">用户管理</a></li>
                    <li><a href="./password1">密码修改</a></li>
                    <li><a href="${pageContext.request.contextPath }/showm.action">信息发布</a></li>
                    
                    <li><a href="${pageContext.request.contextPath }/welcome1.action">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">    
        <div class="search1">
            <img class="wColck" src="img/clock.jpg" alt=""/> 
             <div class="wFont">
                <h1>Admin</h1>
                <p>欢迎来到加油站油罐油量计量标定管理系统!</p>
                <span id="hours"></span>
            </div>
        </div>
    </div>
    </section>
    <footer class="footer">
    </footer>
<script src="js/time.js"></script>


</body>
</html>