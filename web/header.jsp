<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/30
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="Shop"></c:set>
<div class="container">
    <div class="headerstrip">
    <div class="row">
        <div class="span12">
            <a href="#" class="logo pull-left"><img src="img/logo.png" alt="SimpleOne" title="SimpleOne"></a>
            <!-- Top Nav Start -->
            <div class="pull-left">
                <div class="navbar" id="topnav">
                    <div class="navbar-inner">
                        <ul class="nav" >
                            <li><a class="home active" href="#">Home</a>
                            </li>
                            <li><a class="myaccount" href="#">My Account</a>
                            </li>
                            <li><a class="shoppingcart" href="#">Shopping Cart</a>
                            </li>
                            <li><a class="checkout" href="#">CheckOut</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Top Nav End -->
            <div class="pull-right">
                <form class="form-search top-search">
                    <input type="text" class="input-medium search-query" placeholder="搜索商品…">
                </form>
            </div>
        </div>
    </div>
</div>
</div>

