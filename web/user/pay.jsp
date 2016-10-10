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
            <div class="section_container">
                <div class="pay-skip">
                    <h1>感谢您在本商城购物</h1>
                    <div class="payskip-inner">
                        <div>
                            <span>订单号:</span><strong>${requestScope.p2_Order}</strong><span>&#91;请您记住这个号码，以便在付款和查询时使用&#93;</span>
                        </div>
                        <div>
                            <span>支付金额：</span><strong>${requestScope.p3_Amt}</strong>
                        </div>
                        <div>
                            <span>支付方式：</span><span><img class="zffs" src="${shop}Images/yibao.jpg" alt="" /></span>
                        </div>
                        <div>
                            <span>支付银行：</span><span><img class="zfyh" src="${shop}Images/bank/${requestScope.pd_FrpId}.gif" alt="" /></span>
                        </div>
                        <div>
                            <form name="yeepay" action='https://www.yeepay.com/app-merchant-proxy/node' method='POST' target="_blank">
                                <input type='hidden' name='p0_Cmd'   value='${requestScope.p0_Cmd}'>
                                <input type='hidden' name='p1_MerId' value='${requestScope.p1_MerId}'>
                                <input type='hidden' name='p2_Order' value='${requestScope.p2_Order}'>
                                <input type='hidden' name='p3_Amt'   value='${requestScope.p3_Amt}'>
                                <input type='hidden' name='p4_Cur'   value='${requestScope.p4_Cur}'>
                                <input type='hidden' name='p5_Pid'   value='${requestScope.p5_Pid}'>
                                <input type='hidden' name='p6_Pcat'  value='${requestScope.p6_Pcat}'>
                                <input type='hidden' name='p7_Pdesc' value='${requestScope.p7_Pdesc}'>
                                <input type='hidden' name='p8_Url'   value='${requestScope.p8_Url}'>
                                <input type='hidden' name='p9_SAF'   value='${requestScope.p9_SAF}'>
                                <input type='hidden' name='pa_MP'    value='${requestScope.pa_MP}'>
                                <input type='hidden' name='pd_FrpId' value='${requestScope.pd_FrpId}'>
                                <input type="hidden" name="pr_NeedResponse"  value="${requestScope.pr_NeedResponse}">
                                <input type='hidden' name='hmac' value='${requestScope.hmac}'>
                                <div class="pay-inner">
                                    <input type="submit" value="登陆网上银行，立即支付">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
    </div>
</div>

<!-- Footer -->
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
