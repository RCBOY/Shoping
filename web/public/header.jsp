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
<header>
    <div class="headerstrip">
        <div class="container">
            <div class="row">
                <div class="span12">
                    <a href="#" class="logo pull-left"><img src="../img/logo.png" alt="SimpleOne" title="SimpleOne"></a>
                    <!-- 头部导航开始 -->
                    <div class="pull-left">
                        <div class="navbar" id="topnav">
                            <div class="navbar-inner">
                                <ul class="nav" >
                                    <li><a class="home active" href="#">首页</a>
                                    </li>
                                    <li><a class="myaccount" href="#">我的账户</a>
                                    </li>
                                    <li><a class="shoppingcart" href="#">购物车</a>
                                    </li>
                                    <li><a class="checkout" href="#">CheckOut</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- 头部导航结束 -->
                    <!-- 头部搜索框div开始-->
                    <div class="pull-right">
                        <form class="form-search top-search">
                            <input type="text" class="input-medium search-query" placeholder="搜索产品…">
                        </form>
                    </div>
                    <!-- 头部搜索框div结束 -->
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
