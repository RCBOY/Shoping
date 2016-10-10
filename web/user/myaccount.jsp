<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/10
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/public/htmlhead.jsp"%>
</head>
<body>
<%@include file="/public/header.jsp"%>
<div id="maincontainer">
    <section id="product">
        <div class="container">
            <!--  breadcrumb -->
            <ul class="breadcrumb">
                <li>
                    <a href="#">首页</a>
                    <span class="divider">/</span>
                </li>
                <li class="active">我的账户</li>
            </ul>
            <div class="row">

                <!-- My Account-->
                <div class="span9">
                    <h1 class="heading1"><span class="maintext">My Accounts</span><span class="subtext">View All your account information</span></h1>
                    <h3 class="heading3">我的账户</h3>
                    <div class="myaccountbox">
                        <ul>
                            <li>
                                <a href="#">修改个人信息</a>
                            </li>
                            <li>
                                <a href="#">修改密码</a>
                            </li>
                            <li>
                                <a href="#">我的地址</a>
                            </li>
                            <li>
                                <a href="#">我的收藏</a>
                            </li>
                        </ul>
                    </div>
                    <h3 class="heading3">我的订单</h3>
                    <div class="myaccountbox">
                        <ul>
                            <li>
                                <a href="#">查看全部订单</a>
                            </li>
                            <li>
                                <a href="#">未付款订单</a>
                            </li>
                            <li>
                                <a href="#">已付款订单</a>
                            </li>
                            <li>
                                <a href="#">已完成订单</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
