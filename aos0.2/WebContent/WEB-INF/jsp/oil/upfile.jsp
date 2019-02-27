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
                    <li><a href="./message">信息发布</a></li>
                    <li><a href="#" id="active">文件操作</a></li>           
                    <li><a href="./Public">返回主页面</a></li>            
                </ul>
            </nav>
        </div>
        <div class="right"> 
        <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>信息管理>>文件操作页面</span>
            </div>
            <div class="search">            
               <form action="${pageContext.request.contextPath }/upload.action" enctype="multipart/form-data" method="post">
                    <div class="row">
                        <span>选择文件：</span>                                              
                        <input type="file" name="file"/>  
                        <input type="submit" value="上传">    
                    </div>
<!--                     <div class="row">
                        <span>下载文件：</span>
                        <input type="text" placeholder="请输入文件名"/>
                        &nbsp;&nbsp;&nbsp;
                        <input type="button" value="下载"/>      
                    </div>  -->      
                </form>
                <a href="${pageContext.request.contextPath }/downfile.action">下载文件</a>                 
            </div>   
        </div>
    </section>
    <footer class="footer">
    </footer>
<script src="js/time.js"></script>
</body>
</html>