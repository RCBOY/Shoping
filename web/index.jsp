<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/12
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
  <head>
    <%@include file="/public/head.jsp"%>
      <%@include file="/htmlhead.jsp"%>

  </head>
  <body>
  <a href="Send_main_aindex.action">直接到后台</a>
  <a href="Send_user_confirm.action">直接到后台</a>
  <header>
      <div class="headerstrip">
          <div class="container">
              <div class="row">
                  <div class="span12">
                      <a href="#" class="logo pull-left"><img src="img/logo.png" alt="SimpleOne" title="SimpleOne"></a>
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
  <!-- Header End -->

  <div id="maincontainer">
      <div class="container">
          <div class="row">
              <div class="span9">
                  <!-- Slider Start-->
                  <section class="slider">
                      <div id="sliderindex5">
                          <div>
                              <img src="img/banner1.jpg" alt="" title="" />
                          </div>
                          <div>
                              <img src="img/banner2.jpg"  alt="" title=""/>
                          </div>
                          <div>
                              <img src="img/banner1.jpg" alt="" title="" />
                          </div>
                          <div>
                              <img src="img/banner2.jpg" alt="" title="" />
                          </div>
                      </div>
                      <div id="pager" class="sliderindex5pager">
                          <a href="#" class=""><span></span></a>
                          <a href="#" class=""><span></span></a>
                          <a href="#" class=""><span></span></a>
                          <a href="#" class=""><span></span></a>
                      </div>
                  </section>
                  <!-- Slider End-->
                  <!-- Featured Product-->
                  <c:forEach items="${applicationScope.bigList}" var="list">
                  <section id="featured" class="row mt60">
                      <h1 class="heading1"><span class="maintext">${list[0].category.type}</span><span class="subtext"> See Our Most featured Products</span></h1>
                      <ul class="thumbnails">
                          <c:forEach items="${list}" var="product">
                          <li class="span3">
                              <a class="prdocutname" href="${shop}/Product_get.action?id=${product.id}">${product.name}</a>
                              <div class="thumbnail">
                                  <span class="sale tooltip-test">sale</span>
                                  <a href="${shop}/Product_get.action?id=${product.id}"><img alt="" src="${shop}/Images/${product.pic}"></a>
                                  <div class="shortlinks">
                                      <a class="details" href="${shop}/Product_get.action?id=${product.id}">详细</a>
                                      <a class="wishlist" href="#">加入收藏</a>
                                      <a class="compare" href="#">加入对比</a>
                                  </div>
                                  <div class="pricetag">
                                      <span class="spiral"></span><a href="#" class="productcart">加入购物车</a>
                                      <div class="price">
                                          <div class="pricenew">$${product.newprice}</div>
                                          <div class="priceold">$${product.price}</div>
                                      </div>
                                  </div>
                              </div>
                          </li>
                          </c:forEach>
                      </ul>
                  </section>
                  </c:forEach>
                  <!-- Popular Brands-->
                  <section id="popularbrands" class="mt0">
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
              <aside class="span3">
                  <!-- Category-->
                  <div class="sidewidt">
                      <h2 class="heading2"><span>Categories</span></h2>
                      <ul class="nav nav-list categories">
                          <li>
                              <a href="category.html">Men Accessories</a>
                          </li>
                          <li>
                              <a href="category.html">Women Accessories</a>
                          </li>
                          <li>
                              <a href="category.html">Electronics </a>
                          </li>
                          <li>
                              <a href="category.html">Computers </a>
                          </li>
                          <li>
                              <a href="category.html">Home and Furniture</a>
                          </li>
                          <li>
                              <a href="category.html">Others</a>
                          </li>
                      </ul>
                  </div>
                  <!-- Best Seller-->
                  <div class="sidewidt">
                      <h2 class="heading2"><span>Best Seller</span></h2>
                      <ul class="bestseller">
                          <li>
                              <img width="50" height="50" src="img/prodcut-40x40.jpg" alt="product" title="product">
                              <a class="productname" href="product.html"> Product Name</a>
                              <span class="procategory">Women Accessories</span>
                              <span class="price">$250</span>
                          </li>
                          <li>
                              <img width="50" height="50" src="img/prodcut-40x40.jpg" alt="product" title="product">
                              <a class="productname" href="product.html"> Product Name</a>
                              <span class="procategory">Electronics</span>
                              <span class="price">$250</span>
                          </li>
                          <li>
                              <img width="50" height="50" src="img/prodcut-40x40.jpg" alt="product" title="product">
                              <a class="productname" href="product.html"> Product Name</a>
                              <span class="procategory">Electronics</span>
                              <span class="price">$250</span>
                          </li>
                          <li>
                              <img width="50" height="50" src="img/prodcut-40x40.jpg" alt="product" title="product">
                              <a class="productname" href="product.html"> Product Name</a>
                              <span class="procategory">Electronics</span>
                              <span class="price">$250</span>
                          </li>
                      </ul>
                  </div>
                  <!-- Testimonial-->
                  <div class="sidewidt">
                      <h2 class="heading2"><span>Testimonials</span></h2>
                      <div class="flexslider" id="testimonialsidebar">
                          <ul class="slides">
                              <li>
                                  " Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s."<br>
                                  <span class="pull-right orange">By : Themeforest</span>
                              </li>
                              <li>
                                  " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker   of Lorem Ipsum."<br>
                                  <span class="pull-right orange">By : Envato</span>
                              </li>
                              <li>
                                  " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker   of Lorem Ipsum."<br>
                                  <span class="pull-right orange">By : Envato</span>
                              </li>
                              <li>
                                  " Lorem Ipsum is simply dummy text of the printing and  industry. Lorem  has been the industry's standard dummy text ever since the 1500s."<br>
                                  <span class="pull-right orange">By : Themeforest</span>
                              </li>
                              <li>
                                  " It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker."<br>
                                  <span class="pull-right orange">By : Envato</span>
                              </li>
                          </ul>
                      </div>
                  </div>
                  <!-- BMust Have-->
                  <div class="sidewidt mt20">
                      <h2 class="heading2"><span>Must have</span></h2>
                      <div class="flexslider" id="mainsliderside">
                          <ul class="slides">
                              <li>
                                  <img src="img/product1a.jpg" alt="" />
                              </li>
                              <li>
                                  <img src="img/product2a.jpg" alt="" />
                              </li>
                          </ul>
                      </div>
                  </div>
              </aside>
          </div>
      </div>
  </div>
  <!-- /maincontainer -->
  <!-- Footer -->
  <%@include file="/htmlfooter.jsp"%>
  </body>
</html>
