<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/30
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/public/head.jsp"%>
    <%@include file="/htmlhead.jsp"%>
    <link rel="stylesheet" href="${shop}/css/style2.css" />
</head>
<body>
<header>
    <div class="headerstrip">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <a href="index-2.html" class="logo pull-left"><img src="../../img/logo.png" alt="SimpleOne" title="SimpleOne"></a>
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
                            <input type="text" class="input-medium search-query" placeholder="Search Here…">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="headerdetails">
            <div class="pull-right">
                <ul class="nav topcart pull-left">
                    <li class="dropdown hover carticon ">
                        <a href="#" class="dropdown-toggle" > Shopping Cart <span class="label label-orange font14">1 item(s)</span> - $589.50 <b class="caret"></b></a>
                        <ul class="dropdown-menu topcartopen ">
                            <li>
                                <table>
                                    <tbody>
                                    <tr>
                                        <td class="image"><a href="product.html"><img width="50" height="50" src="../../img/prodcut-40x40.jpg" alt="product" title="product"></a></td>
                                        <td class="name"><a href="product.html">MacBook</a></td>
                                        <td class="quantity">x&nbsp;1</td>
                                        <td class="total">$589.50</td>
                                        <td class="remove"><i class="icon-remove"></i></td>
                                    </tr>
                                    <tr>
                                        <td class="image"><a href="product.html"><img width="50" height="50" src="../../img/prodcut-40x40.jpg" alt="product" title="product"></a></td>
                                        <td class="name"><a href="product.html">MacBook</a></td>
                                        <td class="quantity">x&nbsp;1</td>
                                        <td class="total">$589.50</td>
                                        <td class="remove"><i class="icon-remove "></i></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <table>
                                    <tbody>
                                    <tr>
                                        <td class="textright"><b>Sub-Total:</b></td>
                                        <td class="textright">$500.00</td>
                                    </tr>
                                    <tr>
                                        <td class="textright"><b>Eco Tax (-2.00):</b></td>
                                        <td class="textright">$2.00</td>
                                    </tr>
                                    <tr>
                                        <td class="textright"><b>VAT (17.5%):</b></td>
                                        <td class="textright">$87.50</td>
                                    </tr>
                                    <tr>
                                        <td class="textright"><b>Total:</b></td>
                                        <td class="textright">$589.50</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="well pull-right buttonwrap">
                                    <a class="btn btn-orange" href="#">View Cart</a>
                                    <a class="btn btn-orange" href="#">Checkout</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<!-- Header End -->
<div class="check-stup">
    <!-- 商品确认 -->
    <div class="pro-check check ">
        <h1>确认订单信息</h1>
        <table class="data-table cart-table" cellpadding="0" cellspacing="0">
            <tr>
                <th class="align_center" width="10%">商品编号</th>
                <th class="align_left" width="35%" colspan="2">商品名称</th>
                <th class="align_center" width="10%">销售价格</th>
                <th class="align_center" width="20%">数量</th>
                <th class="align_center" width="15%">小计</th>
            </tr>
            <%--<c:forEach items="${sessionScope.forder.sorderList}" var="sorder">--%>
                <tr lang="产品编号">
                    <td class="align_center"><a href="#" class="edit">产品编号</a>
                    </td>
                    <td width="80px"><img src="images/cart1.jpg" width="80"
                                          height="80" />
                    </td>
                    <td class="align_left"><a class="pr_name" href="#">名称</a>
                    </td>
                    <td class="align_center vline">￥ 100</td>
                    <td class="align_center vline">
                            number
                    </td>
                    <td class="align_center vline">￥5000</td>
                </tr>

        </table>

        <div class="sum">
            <div class="fr"><span>总计：</span><b>￥150000</b></div>
        </div>

    </div>
    <!-- 订购人确认 -->
    <form action="#" method="post">
        <div class="person-check check">
            <h1>订购人信息</h1>
            <div class="person-checkinner">
                <div>
                    <label>配送姓名:</label>
                    <input type="text" name="name" />
                </div>
                <div>
                    <label>联系方式:</label>
                    <input type="text" name="phone" />
                </div>
                <div>
                    <label>区域邮编:</label>
                    <input type="text" name="post" />
                </div>
                <div>
                    <label>配送地址:</label>
                    <input type="text" name="address" />
                </div>
            </div>
        </div>
        <!-- 卖家留言 -->
        <div class="person-check check">
            <h1>卖家留言</h1>
            <textarea style="margin: 5px;" name="remark" cols="120" rows="2">输入留言信息</textarea>
            <div class="submit">
                <input type="submit" class="sub-logo fr" style="margin: 0px;padding: 0px; border: 0px;" value="确认无误,购买" />
            </div>
        </div>
    </form>
</div>
</div>

<!-- Footer -->
<%@include file="/htmlfooter.jsp"%>
</body>
</html>
