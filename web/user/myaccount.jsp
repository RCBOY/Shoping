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
    <%@include file="/public/head.jsp"%>
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
                    <h1 class="heading1"><span class="maintext">我的账户</span><span class="subtext">管理您的账户信息</span></h1>
                    <h3 class="heading3">我的账户</h3>
                    <div class="myaccountbox">
                        <ul>
                            <li>
                                <a href="${shop}/user/modifyuser.jsp">修改信息</a>
                            </li>
                            <li>
                                <a href="${shop}/user/modifypass.jsp">修改密码</a>
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
                                <a href="${shop}/Forder_queryForderForAll.action">全部订单</a>
                            </li>
                            <li>
                                <a href="${shop}/Forder_queryForderForPay.action">已付款订单</a>
                            </li>
                            <li>
                                <a href="${shop}/Forder_queryForderNoPay.action">未付款订单</a>
                            </li>
                            <li>
                                <a href="${shop}/Forder_queryForderOnPath.action">已发货订单</a>
                            </li>
                            <li>
                                <a href="${shop}/Forder_queryForderHasOver.action">已完成订单</a>
                            </li>
                        </ul>
                    </div>
                </div>
               <%@include file="/public/accountside.jsp"%>
            </div>

        </div>

    </section>
</div>
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
