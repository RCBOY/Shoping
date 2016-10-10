<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/10
  Time: 9:50
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
                <li class="active">账号注册</li>
            </ul>
            <div class="row">
                <!-- Register Account-->
                <div class="span9">
                    <h1 class="heading1"><span class="maintext">账号注册</span><span class="subtext">Register Your details with us</span></h1>
                    <form class="form-horizontal" action="User_newUser.action" method="post">
                        <h3 class="heading3">个人信息</h3>
                        <div class="registerbox">
                            <fieldset>
                                <div class="control-group">
                                    <label class="control-label"><span class="red">*</span>账户昵称：</label>
                                    <div class="controls">
                                        <input type="text"  class="input-xlarge" name="login">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label"><span class="red">*</span>真实姓名：</label>
                                    <div class="controls">
                                        <input type="text"  class="input-xlarge" name="name">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label"><span class="red">*</span>邮箱：</label>
                                    <div class="controls">
                                        <input type="text"  class="input-xlarge" name="email">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label"><span class="red">*</span>手机号：</label>
                                    <div class="controls">
                                        <input type="text"  class="input-xlarge" name="phone">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label"> 性别：</label>
                                    <div class="controls">
                                        <input type="text"  class="input-xlarge" name="sex">
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                        <h3 class="heading3">设置密码</h3>
                        <div class="registerbox">
                            <fieldset>
                                <div class="control-group">
                                    <label  class="control-label"><span class="red">*</span> 密码:</label>
                                    <div class="controls">
                                        <input type="password"  class="input-xlarge" name="pass">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label  class="control-label"><span class="red">*</span> 确认密码:</label>
                                    <div class="controls">
                                        <input type="password"  class="input-xlarge">
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                        <%--<h3 class="heading3">Newsletter</h3>--%>
                        <%--<div class="registerbox">--%>
                            <%--<fieldset>--%>
                                <%--<div class="control-group">--%>
                                    <%--<label class="control-label">Subscribe:</label>--%>
                                    <%--<div class="controls">--%>
                                        <%--<label class="checkbox inline">--%>
                                            <%--<input type="checkbox" value="option1" >--%>
                                            <%--Yes </label>--%>
                                        <%--<label class="checkbox inline">--%>
                                            <%--<input type="checkbox" value="option2" >--%>
                                            <%--No </label>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</fieldset>--%>
                        <%--</div>--%>
                        <div class="pull-right">
                            <input type="Submit" class="btn btn-orange" value="下一步">
                        </div>
                    </form>
                    <div class="clearfix"></div>
                    <br>
                </div>
                <!-- Sidebar Start-->
                <%--<aside class="span3">--%>
                    <%--<div class="sidewidt">--%>
                        <%--<h2 class="heading2"><span>Account</span></h2>--%>
                        <%--<ul class="nav nav-list categories">--%>
                            <%--<li>--%>
                                <%--<a href="#"> My Account</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Edit Account</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Password</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Wish List</a>--%>
                            <%--</li>--%>
                            <%--<li><a href="#">Order History</a>--%>
                            <%--</li>--%>
                            <%--<li><a href="#">Downloads</a>--%>
                            <%--</li>--%>
                            <%--<li><a href="#">Returns</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#"> Transactions</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="category.html">Newsletter</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="category.html">Logout</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</aside>--%>
                <!-- Sidebar End-->
            </div>
        </div>
    </section>
</div>
<%@include file="public/htmlfooter.jsp"%>
</body>
</html>
