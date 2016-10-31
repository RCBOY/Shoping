<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/20
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<%@include file="/public/head.jsp"%>--%>
    <%@include file="/public/head.jsp"%>
     <%@include file="/public/htmlhead.jsp"%>
    <script>
        function modifyuser() {
            $.ajax({
                type : "post",
                url : "User_modifyUser.action",
                data : $("#modifyuser").serialize(),
                cache : false,
                dataType : "text",
                success : function(dta) {
                    document.getElementById("message").innerHTML=dta;
                    return;
                }
            });
        }
    </script>
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
                <li class="active">修改信息</li>
            </ul>
            <!-- Contact Us-->
            <h1 class="heading1"><span class="maintext">修改信息</span><span class="subtext"> 查看/修改信息</span></h1>
            <div class="row">
                <div class="span9">
                    <form id="modifyuser" class="form-horizontal"  method="post">
                        <fieldset>
                            <div class="control-group">
                                <label for="name" class="control-label">姓名</label>
                                <div class="controls">
                                    <input type="text"  class="required" id="name" value="${sessionScope.user.name}" name="name">
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="email" class="control-label">邮件</label>
                                <div class="controls">
                                    <input type="email"  class="required email" id="email" value="${sessionScope.user.email}" name="email">
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="sex" class="control-label">性别</label>
                                <div class="controls">
                                    <input type="text" class="required" id="sex" value="${sessionScope.user.sex}" name="sex">
                                </div>
                            </div>
                            <div class="control-group">
                                <label for="phone" class="control-label">电话</label>
                                <div class="controls">
                                    <input type="tel" class="required" id="phone" value="${sessionScope.user.phone}" name="phone">
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <label id="message" ></label>
                                </div>
                            </div>
                            <div class="form-actions">
                                <input class="btn" onclick="modifyuser()" type="button" value="修改" >
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
