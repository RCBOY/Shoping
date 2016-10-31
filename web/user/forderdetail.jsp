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
                <li>
                    <a href="${shop}/user/forderquery.jsp">查看全部订单</a>
                    <span class="divider">/</span>
                </li>
                <li class="active">订单详情</li>
            </ul>
            <h1 class="heading1"><span class="maintext">订单详情</span><span class="subtext">查看订单详情</span></h1>
            <div class="cart-info">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th class="id">产品编号</th>
                        <th class="image" colspan="2">商品名称</th>
                        <th class="model">产品数量</th>
                        <th class="model">产品规格</th>
                        <th class="model">产品价格</th>
                    </tr>
                     <c:forEach items="${sessionScope.forderdetaillist}" var="sorder"  varStatus="num">
                        <tr >
                            <td class="id">${sorder.product.id}</td>
                            <td class="image" colspan="2">
                                <a href="#">
                                    <img title="product" alt="product" src="${shop}/Images/${sorder.product.pic}" height="50" width="50">
                                </a>
                                <a href="${shop}/Product_get.action?id=${sorder.product.id}">${sorder.name}</a>
                            </td>
                            <td class="model">${sorder.number}</td>
                            <td class="model">${sorder.message}</td>
                            <td class="model">${sorder.price}</td>
                        </tr>
                         </c:forEach>

                </table>
            </div>
            <div class="cartoptionbox">

                <form class="form-vertical form-inline">
                    <fieldset>
                        <h3 class="heading4">收货信息</h3>
                        <div>收货人：${sessionScope.addressname}</div>
                        <div>收获电话：${sessionScope.addressphone}</div>
                        <div>收货地址：${sessionScope.addressadname}</div>
                        <hr>
                        <h4 class="heading4">物流信息</h4>
                        <div>
                        <div>物流状态：${sessionScope.kdstate}</div>
                        <div>运单号：${sessionScope.kdLogisticCode}</div>
                        <div>订单编号：${sessionScope.ordercode}</div>

                        <c:forEach items="${sessionScope.kdtracelist}" var="tra" >
                            <p></p>
                           ${tra.acceptTime}<br>
                           ${tra.acceptStation}
                        </c:forEach>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </section>
</div>
<!-- Footer -->
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
