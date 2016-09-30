<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/19
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/public/head.jsp"/>
</head>
<body>
<table>
    <c:forEach items="${sessionScope.forder.sorderSet}" var="sorder"  varStatus="num">
        <tr>
            <td>编号:${num.count}</td>
            <td>名称:${sorder.name}</td>
            <td>单价:${sorder.price}</td>
            <td>数量:<input type="text" size="2" value="${sorder.number}"></td>
            <td>小计:${sorder.price*sorder.number}</td>
            <td>操作</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            总价：${sessionScope.forder.total}
        </td>
    </tr>
</table>

</body>
</html>
