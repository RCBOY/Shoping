<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/27
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@include file="/public/head.jsp"%>
   <%@include file="/htmlhead.jsp"%>
</head>
<body>
<!-- Header Start -->
<header>
    <div class="headerstrip">
        <div class="container">

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

<div id="maincontainer">
    <section id="product">
        <div class="container">
            <ul class="breadcrumb">
                <li>
                    <a href="#">首页</a>
                    <span class="divider">/</span>
                </li>
                <li class="active">商品详细</li>
            </ul>
            <!-- Product Details-->
            <div class="row">
                <!-- Left Image-->
                <div class="span5">
                    <ul class="thumbnails mainimage">
                        <li class="span5">
                            <a  rel="position: 'inside' , showTitle: false, adjustX:-4, adjustY:-4" class="thumbnail cloud-zoom" href="img/product1big.jpg">
                                <img src="img/product1big.jpg" alt="" title="">
                            </a>
                        </li>
                        <li class="span5">
                            <a  rel="position: 'inside' , showTitle: false, adjustX:-4, adjustY:-4" class="thumbnail cloud-zoom" href="img/product2big.jpg">
                                <img  src="img/product2big.jpg" alt="" title="">
                            </a>
                        </li>
                        <li class="span5">
                            <a  rel="position: 'inside' , showTitle: false, adjustX:-4, adjustY:-4" class="thumbnail cloud-zoom" href="img/product1big.jpg">
                                <img src="img/product1big.jpg" alt="" title="">
                            </a>
                        </li>
                        <li class="span5">
                            <a  rel="position: 'inside' , showTitle: false, adjustX:-4, adjustY:-4" class="thumbnail cloud-zoom" href="img/product2big.jpg">
                                <img  src="img/product2big.jpg" alt="" title="">
                            </a>
                        </li>
                    </ul>
                    <span>Mouse move on Image to zoom</span>
                    <ul class="thumbnails mainimage">
                        <li class="producthtumb">
                            <a class="thumbnail" >
                                <img  src="img/product1.jpg" alt="" title="">
                            </a>
                        </li>
                        <li class="producthtumb">
                            <a class="thumbnail" >
                                <img  src="img/product2.jpg" alt="" title="">
                            </a>
                        </li>
                        <li class="producthtumb">
                            <a class="thumbnail" >
                                <img  src="img/product1.jpg" alt="" title="">
                            </a>
                        </li>
                        <li class="producthtumb">
                            <a class="thumbnail" >
                                <img  src="img/product2.jpg" alt="" title="">
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- Right Details-->
                <div class="span7">
                    <div class="row">
                        <div class="span7">
                            <h1 class="productname"><span class="bgnone"><h1>${product.name}</h1></span></h1>
                            <div class="productprice">
                                <div class="productpageprice">
                                    <span class="spiral"></span>$${product.newprice}</div>
                                <div class="productpageoldprice">Old price : ${product.price}</div>
                                <ul class="rate">
                                    <span class="bgnone">推荐指数：</span>
                                    <c:forEach var="item" varStatus="status" begin="1" end="${product.star}">
                                        <li class="on"></li>
                                    </c:forEach>
                                    <c:forEach var="item" varStatus="status" begin="${product.star}" end="4">
                                        <li class="off"></li>
                                    </c:forEach>
                                </ul>
                            </div>

                            <div class="quantitybox">
                                <select class="selectsize">
                                    <option>Select Size</option>
                                    <option>Red</option>
                                    <option>Green</option>
                                    <option>Blue</option>
                                    <option>Black</option>
                                </select>
                                <select class="selectqty">
                                    <option>Select</option>
                                    <option>24</option>
                                    <option>36</option>
                                    <option>48</option>
                                </select>
                                <div class="clear"></div>
                                <div class="control-group">
                                    <div class="controls">
                                        <label class="checkbox">
                                            库存：
                                            <span>${product.count}</span>
                                            </label>
                                    </div>
                                </div>
                            </div>
                            <ul class="productpagecart">
                                <li><a class="cart" href="${shop}/Soder_addSorder.action?product.id=${product.id}">添加购物车</a>
                                </li>
                                <li><a class="wish" href="#" >加入收藏</a>
                                </li>
                                <li><a class="comare" href="#" >加入对比</a>
                                </li>
                            </ul>
                            <!-- Product Description tab & comments-->
                            <div class="productdesc">
                                <ul class="nav nav-tabs" id="myTab">
                                    <li class="active"><a href="#description">详细描述</a>
                                    </li>
                                    <li><a href="#specification">产品参数</a>
                                    </li>

                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="description">
                                        <h2>${product.name}</h2>
                                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum <br>
                                        <br>
                                        <ul class="listoption3">
                                            <li>Lorem ipsum dolor sit amet Consectetur adipiscing elit</li>
                                            <li>Integer molestie lorem at massa Facilisis in pretium nisl aliquet</li>
                                            <li>Nulla volutpat aliquam velit </li>
                                            <li>Faucibus porta lacus fringilla vel Aenean sit amet erat nunc Eget porttitor lorem</li>
                                        </ul>
                                    </div>
                                    <div class="tab-pane " id="specification">
                                        <ul class="productinfo">
                                            <li>
                                                <span class="productinfoleft"> 编号:</span> ${product.id}</li>
                                            <li>
                                            <span class="productinfoleft"> 折扣:</span> ${product.discount} </li>
                                            <li>
                                                <span class="productinfoleft"> 原价: </span> ${product.price} </li>
                                            <li>
                                                <span class="productinfoleft"> 尺码:</span> ${product.size} </li>
                                            <li>
                                                <span class="productinfoleft"> 颜色:</span> ${product.color} </li>
                                            <li>
                                            <span class="productinfoleft"> 推荐指数: </span> ${product.star} </li>
                                            <li>
                                            <span class="productinfoleft"> 简介: </span> ${product.remark} </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--  Related Products-->
    <section id="related" class="row">
        <div class="container">
            <h1 class="heading1"><span class="maintext">Related Products</span><span class="subtext"> See Our Most featured Products</span></h1>
            <ul class="thumbnails">
                <li class="span3">
                    <a class="prdocutname" href="product.html">Product Name Here</a>
                    <div class="thumbnail">
                        <span class="sale tooltip-test">Sale</span>
                        <a href="#"><img alt="" src="img/product1.jpg"></a>
                        <div class="shortlinks">
                            <a class="details" href="#">DETAILS</a>
                            <a class="wishlist" href="#">WISHLIST</a>
                            <a class="compare" href="#">COMPARE</a>
                        </div>
                        <div class="pricetag">
                            <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
                            <div class="price">
                                <div class="pricenew">$4459.00</div>
                                <div class="priceold">$5000.00</div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <a class="prdocutname" href="product.html">Product Name Here</a>
                    <div class="thumbnail">
                        <a href="#"><img alt="" src="img/product2.jpg"></a>
                        <div class="shortlinks">
                            <a class="details" href="#">DETAILS</a>
                            <a class="wishlist" href="#">WISHLIST</a>
                            <a class="compare" href="#">COMPARE</a>
                        </div>
                        <div class="pricetag">
                            <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
                            <div class="price">
                                <div class="pricenew">$4459.00</div>
                                <div class="priceold">$5000.00</div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <a class="prdocutname" href="product.html">Product Name Here</a>
                    <div class="thumbnail">
                        <span class="offer tooltip-test" >Offer</span>
                        <a href="#"><img alt="" src="img/product1.jpg"></a>
                        <div class="shortlinks">
                            <a class="details" href="#">DETAILS</a>
                            <a class="wishlist" href="#">WISHLIST</a>
                            <a class="compare" href="#">COMPARE</a>
                        </div>
                        <div class="pricetag">
                            <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
                            <div class="price">
                                <div class="pricenew">$4459.00</div>
                                <div class="priceold">$5000.00</div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <a class="prdocutname" href="product.html">Product Name Here</a>
                    <div class="thumbnail">
                        <a href="#"><img alt="" src="img/product2.jpg"></a>
                        <div class="shortlinks">
                            <a class="details" href="#">DETAILS</a>
                            <a class="wishlist" href="#">WISHLIST</a>
                            <a class="compare" href="#">COMPARE</a>
                        </div>
                        <div class="pricetag">
                            <span class="spiral"></span><a href="#" class="productcart">ADD TO CART</a>
                            <div class="price">
                                <div class="pricenew">$4459.00</div>
                                <div class="priceold">$5000.00</div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </section>
    <!-- Popular Brands-->
    <section id="popularbrands" class="container">
        <h1 class="heading1"><span class="maintext">Popular Brands</span><span class="subtext"> See Our  Popular Brands</span></h1>
        <div class="brandcarousalrelative">
            <ul id="brandcarousal">
                <li><img src="img/brand1.jpg" alt="" title=""/></li>
                <li><img src="img/brand2.jpg" alt="" title=""/></li>
                <li><img src="img/brand3.jpg" alt="" title=""/></li>
                <li><img src="img/brand4.jpg" alt="" title=""/></li>
                <li><img src="img/brand1.jpg" alt="" title=""/></li>
                <li><img src="img/brand2.jpg" alt="" title=""/></li>
                <li><img src="img/brand3.jpg" alt="" title=""/></li>
                <li><img src="img/brand4.jpg" alt="" title=""/></li>
                <li><img src="img/brand1.jpg" alt="" title=""/></li>
                <li><img src="img/brand2.jpg" alt="" title=""/></li>
                <li><img src="img/brand3.jpg" alt="" title=""/></li>
                <li><img src="img/brand4.jpg" alt="" title=""/></li>
            </ul>
            <div class="clearfix"></div>
            <a id="prev" class="prev" href="#">&lt;</a>
            <a id="next" class="next" href="#">&gt;</a>
        </div>
    </section>
</div>

<!-- Footer -->
<%--<footer id="footer">--%>
    <%@include file="/htmlfooter.jsp"%>
<%--</footer>--%>
</body>
</html>
