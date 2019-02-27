<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
    <meta charset="UTF-8">
    <title>加油站油罐油量计量标定管理系统</title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/public1.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>加油站油罐油量计量标定管理系统</h1>
        <div class="publicHeaderR">
            <p><span id="hours"></span><span style="color: #fff21b"> ${uname}</span> 欢迎你！</p>
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
                    <li><a href="./userlist" >用户管理</a></li>
                    <li  id="active"><a href="#">密码修改</a></li>
                    <li><a href="${pageContext.request.contextPath }/Public">返回上一级</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">    
            <div class="location" >
                <strong>你现在所在的位置是:</strong>
                <span>用户管理>>密码修改页面</span>
            </div>
            <div class="providerAdd">
                <form action="#" method="post">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div>
                        <label for="userName">用户名称：</label>
                        <input type="text" name="userName" id="userName"/>
                        <span >*请输入你要修改密码的用户名称</span>
                    </div>
                    <div class="">
                        <label for="oldPassword">旧密码：</label>
                        <input type="password" name="oldPassword" id="oldPassword" required/>
                        <span>*请输入原密码</span>
                    </div>
                    <div>
                        <label for="newPassword">新密码：</label>
                        <input type="password" name="newPassword" id="newPassword" required/>
                        <span >*请输入新密码</span>
                    </div>
                    <div>
                        <label for="reNewPassword">确认新密码：</label>
                        <input type="password" name="reNewPassword" id="reNewPassword" required/>
                        <span >*请输入新确认密码，保证和新密码一致</span>
                    </div>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <input type="button" value="保存" onclick="history.back(-1)"/>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <footer class="footer">
    </footer>
<script src="js/time.js"></script>

<script src="js/jquery.js"></script>
</body>
</html>