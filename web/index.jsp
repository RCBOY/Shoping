<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/12
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%@include file="/public/head.jsp"%>
  </head>
  <body>
  <a href="Send_main_aindex.action">直接后台frame版</a>
  <a href="Send_main_aindex.action">直接后台EasyUI版</a>
 <a href="${Shop}/Category_save.action">save</a>
  <a href="Category_update.action?category.id=1&category.type=儿童休闲&category.hot=true">update</a>
  <a href="Category_update.action?id=1&type=儿童休闲&hot=true">updateModelDriven</a>
  <a href="Account_update.action?id=1&login=admin&name=jj&pass=123">AccountupdateModelDriven</a>
  <a href="Category_query.action">查询所有类别</a>
<c:forEach items="${requestScope.CategoryList}" var="category">
  ${category.id}|${category.type}|${category.hot}<br/>
</c:forEach>
<c:forEach items="${sessionScope.CategoryList}" var="category">
  ${category.id}|${category.type}|${category.hot}<br/>
</c:forEach>
<c:forEach items="${applicationScope.CategoryList}" var="category">
  ${category.id}|${category.type}|${category.hot}<br/>
</c:forEach>
  </body>
</html>
