<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/29
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/public/head.jsp"%>
    <%@include file="htmlhead.jsp"%>
</head>
<body>
<!-- Header Start -->
<header>
    <div class="headerstrip">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <a href="index-2.html" class="logo pull-left"><img src="img/logo.png" alt="SimpleOne" title="SimpleOne"></a>
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
                            <input type="text" class="input-medium search-query" placeholder="搜索产品…">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="headerdetails">
        </div>
    </div>
</header>
<!-- Header End -->

<div id="maincontainer">
    <section id="product">
        <div class="container">
            <!--  breadcrumb -->
            <ul class="breadcrumb">
                <li>
                    <a href="#">首页</a>
                    <span class="divider">/</span>
                </li>
                <li class="active">购物车</li>
            </ul>
            <h1 class="heading1"><span class="maintext"> 购物车</span><span class="subtext"> All items in your  Shopping Cart</span></h1>
            <!-- Cart-->
            <div class="cart-info">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th class="id">编号</th>
                        <th class="image" colspan="2">商品名称</th>
                        <%--<th class="name">产品名称</th>--%>
                        <th class="model">产品简介</th>
                        <th class="quantity">数量</th>
                        <th class="discount">折扣</th>
                        <th class="total">操作</th>
                        <th class="price">单价</th>
                        <th class="total">小计</th>
                    </tr>
                   <c:forEach items="${sessionScope.forder.sorderSet}" var="sorder"  varStatus="num">
                    <tr>
                        <td class="id">${num.count}</td>
                        <td class="image" colspan="2">
                            <a href="#">
                                <img title="product" alt="product" src="img/prodcut-40x40.jpg" height="50" width="50">
                            </a>
                            <a href="#">${sorder.name}</a>
                        </td>
                        <td class="model">${sorder.product.remark}</td>
                        <td class="quantity">
                            <input type="text" size="2" value="${sorder.number}" name="quantity[40]" class="span1">
                        </td>
                        <td class="discount">${sorder.product.discount/10}折</td>
                        <td class="total">
                            <a href="#"><img class="tooltip-test" data-original-title="修改" src="img/update.png" alt=""></a>
                            <a href="#"><img class="tooltip-test" data-original-title="移除"  src="img/remove.png" alt=""></a>
                        </td>
                        <td class="price">${sorder.price}</td>
                        <td class="total">${sorder.price*sorder.number}</td>
                    </tr>
                  </c:forEach>
                </table>
            </div>
            <div class="cartoptionbox">
                <h4 class="heading4"> Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost. </h4>
                <input type="radio" class="radio">
                Use Coupon Code <br>
                <input type="radio" class="radio">
                Use Gift Voucher <br>
                <input type="radio" class="radio" checked="checked">
                Estimate Shipping & Taxes <br><br>
                <form class="form-vertical form-inline">
                    <h4 class="heading4"> Enter your destination to get a shipping estimate.</h4>
                    <fieldset>
                        <div class="control-group">
                            <label  class="control-label">Select list</label>
                            <div class="controls">
                                <select  class="span3 cartcountry">
                                    <option>Country:</option>
                                    <option>United Kindom</option>
                                    <option>United States</option>
                                </select>
                                <select class="span3 cartstate">
                                    <option>Region / State:</option>
                                    <option>Angus</option>
                                    <option>highlands</option>
                                </select>
                                <input type="submit" value="Get Quotes" class="btn btn-orange">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="container">
                <div class="pull-right">
                    <div class="span4 pull-right">
                        <table class="table table-striped table-bordered ">
                            <tr>
                                <td><span class="extra bold">购物车总价:</span></td>
                                <td><span class="bold">101</span></td>
                            </tr>
                            <tr>
                                <td><span class="extra bold">Eco Tax (-5.00) :</span></td>
                                <td><span class="bold">$11.0</span></td>
                            </tr>
                            <tr>
                                <td><span class="extra bold">VAT (18.2%) :</span></td>
                                <td><span class="bold">$21.0</span></td>
                            </tr>
                            <tr>
                                <td><span class="extra bold totalamout">总计 :</span></td>
                                <td><span class="bold totalamout">${sessionScope.forder.total}</span></td>
                            </tr>
                        </table>
                        <%--<input type="submit" value="结账" class="btn btn-orange pull-right">--%>
                        <button class="btn btn-orange pull-right">
                            <font><a href="${shop}/">结确认订单</a></font>
                        </button>
                        <button class="btn btn-orange pull-right mr10">
                            <font><a href="#">继续购物</a></font>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<%@include file="htmlfooter.jsp"%>
</body>
</html>
