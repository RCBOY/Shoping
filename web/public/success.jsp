<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/2
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>error</title>
    <script language="javascript" type="text/javascript">
        var timer;
        //启动跳转的定时器
        function startTimes() {
            timer = window.setInterval(showSecondes,1000);
        }

        var i = 5;
        function showSecondes() {
            if (i > 0) {
                i--;
                document.getElementById("secondes").innerHTML = i;
            }
            else {
                window.clearInterval(timer);
                location.href = "/index.jsp";
            }
        }

        //取消跳转
        function resetTimer() {
            if (timer != null && timer != undefined) {
                window.clearInterval(timer);
                location.href = "/index.jsp";
            }
        }
    </script>
    <%--<meta http-equiv=refresh content=3;url=http://www.hao123.com />--%>
    <style type=text/css>
        .font14 {
            font-size: 14px
        }

        .font12 {
            font-size: 12px
        }

        .font12 a {
            font-size: 12px;
            color: #CC0000;
            text-decoration: none;
        }
    </style>
</head>
<body class="error_page" onload="startTimes();">
<table height=500 cellSpacing=0 cellPadding=0 width=500 align=center
       background=/Images/gif026.gif border=0>
    <tbody>
    <tr>
        <td height=330></td>
    </tr>
    <tr>
        <td vAlign=top>
            <div class=font14 align=center>
                <strong> ${sessionScope.message}</strong><br />
                <font color=#666666>
                   &nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转至首页，立即跳转请点击&nbsp;
                    <a  href="javascript:resetTimer();">跳转</a>
               </font>
            </div>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
