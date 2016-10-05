<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/1
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%--<%@include file="/public/head.jsp"%>--%>
    <%@include file="/public/htmlhead.jsp"%>
    <link rel="stylesheet" href="${shop}/css/style2.css" />
</head>
<body>
<%@include file="/public/header.jsp"%>
<div class="check-stup">
    <div class="container">
        <!-- 确认订单信息 -->
        <div class="pay-step">
            <!-- 订购人确认 -->
            <div class="person-check check">
                <h1>您的订单已经生成</h1>
                <div class="person-checkinner">
                    <div><span>订单号</span>：<span>${sessionScope.oldforder.id}</span></div>
                    <div><span>收货人</span>：<span>${sessionScope.oldforder.address.name}</span></div>
                    <div><span>送货地址</span>：<span>${sessionScope.oldforder.address.addressname}</span></div>
                    <div><span>联系电话</span>：<span>${sessionScope.oldforder.address.phone}</span></div>
                    <div><span>支付金额</span>：<span>${sessionScope.oldforder.total}</span></div>
                </div>
            </div>
            <div class="pay">
                <div class="pay-inner">
                    <div class="fl">支付方式:</div>
                    <div class="fl yibao-logo">
                        <a href=""><img src="${shop}/Images/yibao.jpg" width="110" height="35" alt="" /></a>
                    </div>
                    <div class="fr blue aa">世界一流的电子支付应用和服务提供商
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="red"href="">如何使用?</a>
                    </div>

                </div>
            </div>
            <div class="select-bank">
                <form action="${shop}/Pay_goBank.action" method="post">
                    <h1>请选择支付银行</h1>
                    <div>
                        <ul>
                            <c:forEach items="${applicationScope.bankList}" var="bankImage">
                                <li>
                                    <input type="radio" name="pd_FrpId" value="${fn:substring(bankImage,0,fn:indexOf(bankImage,'.'))}" />&nbsp;
                                    <img src="${shop}/Images/bank/${bankImage}" />
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="clear"></div>
                    <div class="reminder"><span>请确保您的银行卡已开通网银支付功能，否则没有办法完成支付&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <a href="">如何开通?</a></div>
                    <div class="pay-submit">
                        <div class="pay-inner">
                            <input type="submit" style="width: 80px; height: 40px;" value="确认提交" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
