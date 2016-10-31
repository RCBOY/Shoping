<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/30
  Time: 9:19
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
                    <a href="${shop}/index.jsp">首页</a>
                    <span class="divider">/</span>
                </li>
                <li>
                    <a href="${shop}/user/myaccount.jsp">我的账户</a>
                    <span class="divider">/</span>
                </li>
                <li>
                    <a href="${shop}/user/forderquery.jsp">查看全部订单</a>
                    <span class="divider">/</span>
                </li>
                <li>
                    <a href="${shop}/user/forderdetail.jsp">订单详情</a>
                    <span class="divider">/</span>
                </li>
                <li class="active">快递信息</li>
            </ul>
            <h1 class="heading1"><span class="maintext">物流详情</span><span class="subtext">查看物流详情</span></h1>
            <div class="cartoptionbox">

                <form class="form-vertical form-inline">
                    <fieldset>
                        <h4 class="heading4">物流信息</h4>
                        <div>物流状态：${sessionScope.kdstate}</div>
                        <div>运单号：${sessionScope.kdLogisticCode}</div>
                        <div>订单编号：${sessionScope.ordercode}</div>

                        <%--<c:forEach items="${sessionScope.kdtracelist}" var="trace" >--%>
                        <%--<p>${trace.}&nbsp;${trace.Location}</p>--%>
                        <%--<p>${trace.AcceptStation}</p>--%>
                        <%--</c:forEach>--%>

                    </fieldset>
                </form>
            </div>
        </div>
    </section>
</div>
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
