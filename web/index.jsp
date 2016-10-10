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
      <%@include file="/public/htmlhead.jsp"%>
  </head>
  <body>
  <%@include file="/public/header.jsp"%>
  <div id="maincontainer">
      <div class="container">
          <div class="row">
              <div class="span9">
                  <!-- Slider Start-->
                  <section class="slider">
                      <div id="sliderindex5">

                              <c:forEach items="${applicationScope.fiveStarList}" var="product">
                          <div>
                            <a href="${shop}/Product_get.action?id=${product.id}" ><img src="img/banner2.jpg" alt="" title=""/></a>
                          </div>
                              </c:forEach>
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
                                  <a href="${shop}/Product_get.action?id=${product.id}"><img alt="" src="${shop}/Images/${product.pic}" height="350" width="270"></a>
                                  <div class="shortlinks">
                                      <a class="details" href="${shop}/Product_get.action?id=${product.id}">详细</a>
                                      <a class="wishlist" href="#">加入收藏</a>
                                      <a class="compare" href="#">加入对比</a>
                                  </div>
                                  <div class="pricetag">
                                      <span class="spiral"></span><a href="${shop}/Sorder_addSorder.action?product.id=${product.id}" class="productcart">加入购物车</a>
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
                      <h1 class="heading1"><span class="maintext">品牌展示</span><span class="subtext"> See Our  Popular Brands</span></h1>
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
                      <h2 class="heading2"><span>类别</span></h2>
                      <ul class="nav nav-list categories">
                          <c:forEach items="${applicationScope.categoryList}" var="category">
                          <li>
                              <a href="${shop}/Page_queryProductForPage.action?cid=${category.id}">${category.type}</a>
                          </li>
                          </c:forEach>
                      </ul>
                  </div>
                  <!-- Best Seller-->
                  <div class="sidewidt">
                      <h2 class="heading2"><span>商城推荐</span></h2>
                      <ul class="bestseller">
                          <c:forEach items="${applicationScope.starList}" var="productstar">
                          <li>
                              <img width="50" height="50" src="${shop}Images/${productstar.pic}" alt="product" title="product">
                              <a class="productname" href="${shop}/Product_get.action?id=${productstar.id}"> ${productstar.name}</a>
                              <span class="procategory">${productstar.remark}</span>
                              <span class="price">${productstar.price}</span>
                          </li>
                          </c:forEach>
                      </ul>
                  </div>
                  <!-- Testimonial-->
                  <div class="sidewidt">
                      <h2 class="heading2"><span>商城公告</span></h2>
                      <div class="flexslider" id="testimonialsidebar">
                          <ul class="slides">
                              <c:forEach items="${applicationScope.noticeList}" var="notice">
                              <li>
                                  ${notice.content}<br>
                                  <span class="pull-right orange">By :${notice.account.name}</span>
                              </li>
                              </c:forEach>
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
  <%@include file="/public/htmlfooter.jsp"%>
  </body>
</html>
