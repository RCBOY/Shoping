<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/8
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/public/head.jsp"%>
    <%@include file="/public/htmlhead.jsp"%>
</head>
<body>
<%@include file="/public/header.jsp"%>
<div id="maincontainer">
    <section id="product">
        <div class="container">
            <!--  breadcrumb -->
            <ul class="breadcrumb">
                <li>
                    <a href="#">首页</a>
                    <span class="divider">/</span>
                </li>
                <li class="active">类别</li>
            </ul>
            <div class="row">
                <!-- Sidebar Start-->
                <aside class="span3">
                    <!-- Category-->
                    <div class="sidewidt">
                        <h2 class="heading2"><span>类别</span></h2>
                        <ul class="nav nav-list categories">
                            <c:forEach items="${applicationScope.categoryList}" var="category2">
                                <li>
                                    <a href="category.html">${category2.type}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <!--  Best Seller -->
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
                    <!-- Latest Product -->
                    <div class="sidewidt">
                        <h2 class="heading2"><span>最新上架</span></h2>
                        <ul class="bestseller">
                         <c:forEach items="${applicationScope.lastProductList}" var="product">
                            <li>
                                <img width="50" height="50" src="${shop}/Images/${product.pic}" alt="product" title="product">
                                <a class="productname" href="${shop}/Product_get.action?id=${product.id}">${product.name}</a>
                                <span class="procategory">${product.remark}</span>
                                <span class="price">${product.price}</span>
                            </li>
                             </c:forEach>
                        </ul>
                    </div>
                    <!--  Must have -->
                    <div class="sidewidt">
                        <h2 class="heading2"><span>你值得拥有</span></h2>
                        <div class="flexslider" id="mainslider">
                            <ul class="slides">
                                <li>
                                    <img src="img/product1.jpg" alt="" />
                                </li>
                                <li>
                                    <img src="img/product2.jpg" alt="" />
                                </li>
                            </ul>
                        </div>
                    </div>
                </aside>
                <!-- Sidebar End-->
                <!-- Category-->
                <div class="span9">
                    <!-- Category Products-->
                    <section id="category">
                        <div class="row">
                            <div class="span9">
                                <!-- Sorting-->
                                <div class="sorting well">
                                    <form class=" form-inline pull-left">
                                         排序 :
                                        <select class="span2">
                                            <option value="">默认</option>
                                            <option value="">商品名</option>
                                            <option value="">价格从高到底</option>
                                            <option value="">价格从低到高 </option>
                                            <option value="discount">折扣从大到小</option>
                                        </select>
                                        &nbsp;&nbsp;
                                        数量:
                                        <select class="span1">
                                            <option value="5">5</option>
                                            <option value="10">10</option>
                                            <option value="15">15</option>
                                            <option value="20">20</option>
                                        </select>
                                    </form>
                                    <div class="btn-group pull-right">
                                        <button class="btn" id="list"><i class="icon-th-list"></i>
                                        </button>
                                        <button class="btn btn-orange" id="grid"><i class="icon-th icon-white"></i></button>
                                    </div>
                                </div>
                                <!-- Category-->
                                <section id="categorygrid">
                                    <ul class="thumbnails grid">

                                        <c:forEach items="${sessionScope.categoryProductList}" var="list">
                                        <li class="span3">
                                            <a class="prdocutname" href="product.html">${list.name}</a>
                                            <div class="thumbnail">
                                                <span class="sale tooltip-test">Sale</span>
                                                <a href="#"><img alt="" src="${shop}/Images/${list.pic}"></a>
                                                <div class="shortlinks">
                                                    <a class="details" href="#">详细</a>
                                                    <a class="wishlist" href="#">加入收藏</a>
                                                    <a class="compare" href="#">加入对比</a>
                                                </div>
                                                <div class="pricetag">
                                                    <span class="spiral"></span><a href="#" class="productcart">加入购物车</a>
                                                    <div class="price">
                                                        <div class="pricenew">$${list.newprice}</div>
                                                        <div class="priceold">$${list.price}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                    <ul class="thumbnails list row">
                                      <c:forEach items="${sessionScope.categoryProductList}" var="list">
                                        <li>
                                            <div class="thumbnail">
                                                <div class="row">
                                                    <div class="span3">
                                                        <span class="offer tooltip-test" >Offer</span>
                                                        <a href="#"><img alt="" src="img/product1.jpg"></a>
                                                    </div>
                                                    <div class="span6">
                                                        <a class="prdocutname" href="product.html">${list.name}}</a>
                                                        <div class="productdiscrption"> ${list.remark}<br>
                                                            <br>
                                                           ${list.xremark} </div>
                                                        <div class="pricetag">
                                                            <span class="spiral"></span><a href="#" class="productcart">加入购物车</a>
                                                            <div class="price">
                                                                <div class="pricenew">$${list.newprice}</div>
                                                                <div class="priceold">$${list.price}</div>
                                                            </div>
                                                        </div>
                                                        <div class="shortlinks">
                                                            <a class="details" href="#">详细</a>
                                                            <a class="wishlist" href="#">加入收藏</a>
                                                            <a class="compare" href="#">加入对比</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                       </c:forEach>
                                    </ul>
                                    <div class="pagination pull-right">
                                        <ul>
                                            <c:if test="${sessionScope.pageBean.currentPage==1}" >
                                                <li>
                                                    第一页
                                                </li>
                                                <li>
                                                    上一页
                                                </li>
                                            </c:if>
                                            <s:else>
                                               <li><a href="${shop}/Page_queryProductForPage.action?cid=${category.id}&page=${1}">第一页</a></li>
                                               <li><a href="listMyArticle.action?cid=${category.id}&page=${sessionScope.pageBean.currentPage-1}">"上一页</a></li>
                                            </s:else>
                                            <c:if test="${sessionScope.pageBean.currentPage }！=${ sessionScope.pageBean.totalPage}" >
                                               <li><a href="listMyArticle.action?cid=${category.id}&page=${sessionScope.pageBean.currentPage+1}">下一页</a></li>
                                                <li><a href="${shop}/Page_queryProductForPage.action?cid=${category.id}&page=${sessionScope.pageBean.totalPage}">最后一页</a></li>
                                            </c:if>
                                            <s:else>
                                                <li>
                                                    下一页
                                                </li>
                                                <li>
                                                    最后一页
                                                </li>
                                            </s:else>
                                            <%--<li><a href="#">上一页</a>--%>
                                            <%--</li>--%>
                                            <%--<li class="active"><a href="#">1</a>--%>
                                            <%--</li>--%>
                                            <%--<li><a href="#">2</a>--%>
                                            <%--</li>--%>
                                            <%--<li><a href="#">3</a>--%>
                                            <%--</li>--%>
                                            <%--<li><a href="#">4</a>--%>
                                            <%--</li>--%>
                                            <%--<li><a href="#">下一页</a>--%>
                                            <%--</li>--%>
                                        </ul>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </section>
</div>


<%@include file="/public/htmlfooter.jsp"%>
</body>
</html>
