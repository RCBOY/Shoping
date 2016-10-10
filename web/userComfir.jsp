<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/10
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/public/head.jsp"%>
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
                        <div class="successmsg alert">
                            <a class="clostalert">close</a>
                            <strong>Sucess!</strong> ${sessionScope.message} </div>
                            <form name="yeepay" action='User_forComfirUser.action' method='POST' target="_blank">
                                <span>请输入验证码：</span>  <input type='text' name='code'>
                                <div class="pay-inner">
                                   <input type="submit" value="确定">
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
<%@include file="public/htmlfooter.jsp"%>
</body>
</html>
