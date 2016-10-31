<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/22
  Time: 16:44
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
                <li class="active">全部订单</li>
            </ul>
            <h1 class="heading1"><span class="maintext">${sessionScope.queryTile}</span><span class="subtext">查看${sessionScope.queryTile}</span></h1>
            <div class="cart-info">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th class="id">订单编号</th>
                        <th class="model">创建时间</th>
                        <th class="model">订单状态</th>
                        <th class="model">订单详情</th>
                        <th class="total">订单总价</th>
                        <th class="total">操作</th>
                    </tr>
                     <c:forEach items="${sessionScope.userforder}" var="forder"  varStatus="num">
                        <tr >
                            <td class="id">${forder.id}</td>
                            <td class="model">${forder.date}</td>
                            <td class="model">${forder.status.status}</td>
                            <td class="model"><a href="${shop}/Sorder_ getSorderDetail.action?forder.id=${forder.id}&aid=${forder.address.id}">订单详情</a></td>
                            <td class="price">￥${forder.total}</td>
                            <c:if test="${forder.status.id=='4'}">
                            <td class="total">
                                <%--<a href="#"><img class="tooltip-test" data-original-title="取消" src="../img/update.png" alt=""></a>--%>
                                <a href="#"><img class="tooltip-test" data-original-title="移除"  src="../img/remove.png" alt=""></a>
                            </td>
                            </c:if>
                            <c:if test="${forder.status.id=='3'}">
                                <td class="total">
                                    <a href="#" class="btn">确认收货</a>
                                </td>
                            </c:if>
                            <c:if test="${forder.status.id=='2'}">
                                <td class="total">
                                        <a href="#"><img class="tooltip-test" data-original-title="修改" src="../img/update.png" alt=""></a>
                                    <a href="#"><img class="tooltip-test" data-original-title="移除"  src="../img/remove.png" alt=""></a>
                                </td>
                            </c:if>
                            <c:if test="${forder.status.id=='1'}">
                                <td class="total">
                                    <a href="#"><img class="tooltip-test" data-original-title="修改" src="../img/update.png" alt=""></a>
                                    <a href="#"><img class="tooltip-test" data-original-title="移除"  src="../img/remove.png" alt=""></a>
                                </td>
                            </c:if>
                        </tr>
                         </c:forEach>
                </table>
            </div>
        </div>
    </section>
</div>
<!-- Footer -->
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
