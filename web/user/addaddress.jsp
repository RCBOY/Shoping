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
                <li class="active">地址管理</li>
            </ul>
            <!-- Contact Us-->
            <h1 class="heading1"><span class="maintext">修改密码</span><span class="subtext"> 修改密码</span></h1>
            <div class="row">
                <div class="span9">
                    <form  id="modifypass" class="form-horizontal"  method="post">
                        <fieldset>
                            <div class="control-group">
                                <label for="oldpass" class="control-label">原始密码</label>
                                <div class="controls">
                                    <input type="password"  class="required" id="oldpass" name="oldpass">
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="pass2" class="control-label">输入新密码</label>
                                <div class="controls">
                                    <input type=password  class="required" id="pass2"  >
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="pass" class="control-label">确认新密码</label>
                                <div class="controls">
                                    <input type="password" class="required" id="pass"  name="pass">
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <label id="message" ></label>
                                </div>
                            </div>
                            <div class="form-actions">
                                <input class="btn" type="button" onclick="modifypass()"  value="修改" >
                                <input class="btn" type="reset" value="重置">
                            </div>
                        </fieldset>
                    </form>
                </div>

                <!-- Sidebar Start-->
                <%@include file="/public/accountside.jsp"%>
                <!-- Sidebar End-->

            </div>
        </div>
    </section>
</div>
<!-- Footer -->
<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
