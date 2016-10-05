<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/30
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<%@include file="/public/head.jsp"%>--%>
    <%@include file="/public/htmlhead.jsp"%>
    <link rel="stylesheet" href="${shop}/css/style2.css" />
        <%
        response.setHeader("Pragma","No-store");
        response.setHeader("Cache-Control","no-store");
    %>
</head>
<body>
<c:if test="${empty sessionScope.forder.sorderSet}">
    <c:redirect url="${shop}/public/error.jsp" ></c:redirect>
</c:if>
<%@include file="/public/header.jsp"%>
<!-- Header End -->
    <div class="check-stup">
    <div class="container">
        <ul class="breadcrumb">
            <li>
                <a href="#">首页</a>
                <span class="divider">/</span>
            </li>
            <li>
                <a href="#">购物车</a>
                <span class="active">/</span>
            </li>
            <li class="active">
                商品详细
            </li>
        </ul>
        <!-- 商品确认 -->
    <div class="pro-check check ">
        <h1>确认订单信息</h1>
        <table class="data-table cart-table" cellpadding="0" cellspacing="0">
            <tr>
                <th class="align_center" width="10%">商品编号</th>
                <th class="align_left" width="35%" colspan="2">商品名称</th>
                <th class="align_center" width="10%">销售价格</th>
                <th class="align_center" width="20%">数量</th>
                <th class="align_center" width="15%">小计</th>
            </tr>
            <c:forEach items="${sessionScope.forder.sorderSet}" var="sorder">
                <tr lang="产品编号">
                    <td class="align_center"><a href="#" class="edit">${sorder.product.id}</a>
                    </td>
                    <td width="80px"><img src="${shop}/Images/${sorder.product.pic}" width="80" height="80" />
                    </td>
                    <td class="align_left"><a class="pr_name" href="#">${sorder.name}</a>
                    </td>
                    <td class="align_center vline">￥ ${sorder.price}</td>
                    <td class="align_center vline">
                ${sorder.number}
                    </td>
                    <td class="align_center vline">￥${sorder.price*sorder.number}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="sum">
            <div class="fr"><span>总计：</span><b>￥${forder.total}</b></div>
        </div>
        </div>
    </div>
    <%--</div>--%>
    <!-- 订购人确认 -->
    <div class="container">
    <form action="${shop}/Forder_save.action" method="post">
        <div class="person-check check">
            <h1>确认订购人信息</h1>
                <%--<form class="form-vertical form-inline">--%>
                    <h4 class="heading4"> Enter your destination to get a shipping estimate.</h4>
                    <%--<fieldset>--%>
                        <div class="control-group">
                            <table class="table table-bordered table-striped badges">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>收件人</th>
                                    <th>电话</th>
                                    <th>收件地址</th>
                                </tr>
                                </thead>
                                <td>
                                <tbody>
                                <c:forEach items="${sessionScope.user.addressSet}" var="address" varStatus="num">
                                    <tr>
                                       <td> <input type="radio" id="${num.count}" name="aid" value="${address.id}"></td>
                                        <td> ${address.name} </td>
                                        <td><span class="badge">${address.phone}</span></td>
                                        <td><code>${address.addressname}</code></td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            </div>
                    <%--</fieldset>--%>
                <%--</form>--%>
        </div>
        <!-- 卖家留言 -->
        <div class="person-check check">
            <h1>卖家留言</h1>
            <textarea style="margin: 5px;" name="remark" cols="120" rows="2">输入留言信息</textarea>
            <div class="submit">
                <input type="submit" class="sub-logo fr" style="margin: 0px;padding: 0px; border: 0px;" value="确认无误,购买">
            </div>
        </div>
    </form>
    </div>
    </div>

<!-- Footer -->
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>