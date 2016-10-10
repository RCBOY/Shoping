<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/8
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>管理员登陆</title>
    <link rel="stylesheet" href="style.css" type="text/css" />
    <script type="text/javascript" src="jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="selectivizr.js"></script>
    <noscript><link rel="stylesheet" href="fallback.css" /></noscript>
</head>
<body>
<div id="container">
    <form action="Account_Login.action" method="post">
        <div class="login">登入</div>
        <div class="username-text">管理员:</div>
        <div class="password-text">密码:</div>
        <div class="username-field">
            <input type="text" name="login" value="azmind" />
        </div>
        <div class="password-field">
            <input type="password" name="pass" value="azmind" />
        </div>
        <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住我</label>
        <div>${sessionScope.accountError}</div>
        <div class="forgot-usr-pwd">忘记 <a href="#">用户名</a> 或 <a href="#">密码</a>?</div>
        <input type="submit" name="submit" value="GO" />
    </form>
</div>
</body>
</html>
