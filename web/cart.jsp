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
    <%@include file="public/htmlhead.jsp"%>
    <script type="text/javascript">
        $(function () {
//            注册时间
            $(".span1").change(function () {
//                验证数据有效性,必须大于0
                var number=this.value;
                if(!isNaN(number)&&parseInt(number)==number&&number>0){
                    $(this).attr("lang",number);
                    var pid=$(this).parents("tr:first").attr("lang");
//                    发送ajax请求，传输当前的数量与商品的id返回的总价
                    $.post("Sorder_updateSorder.action",{number:number,'product.id':pid},function (total) {
                        $("#total").html("￥" + parseFloat(total).toFixed(2));
                    },"text")
//                        更新单个商品的小计
                    var price=$(this).parent().prev().html();
                    price=price.substring(1);
//                     xxxx.toFixed(2) 对指定的数保留两位小树, 支持四舍五入
                   $(this).parent().next().html("￥" + parseFloat(price*number).toFixed(2));

                }else {
                    this.value=$(this).attr("lang");
                }
            })
        })
    </script>
</head>
<body>
<!-- Header Start -->
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
                        <th class="quantity">单价</th>
                        <th class="price">数量</th>
                        <th class="total">小计</th>
                        <th class="discount">折扣</th>
                        <th class="total">操作</th>
                    </tr>
                   <c:forEach items="${sessionScope.forder.sorderSet}" var="sorder"  varStatus="num">
                    <tr lang="${sorder.product.id}">
                        <td class="id">${num.count}</td>
                        <td class="image" colspan="2">
                            <a href="#">
                                <img title="product" alt="product" src="${shop}/Images/${sorder.product.pic}" height="50" width="50">
                            </a>
                            <a href="#">${sorder.name}</a>
                        </td>
                        <td class="model">${sorder.product.remark}</td>
                        <td class="price">￥${sorder.price}</td>
                        <td class="quantity">
                            <input type="text" size="2" value="${sorder.number}" name="quantity[40]" class="span1" lang="${sorder.number}">
                        </td>
                        <td class="total" id="littletotal">￥${sorder.price*sorder.number}</td>
                        <td class="discount">${sorder.product.discount/10}折</td>
                        <td class="total">
                            <a href="#"><img class="tooltip-test" data-original-title="修改" src="img/update.png" alt=""></a>
                            <a href="#"><img class="tooltip-test" data-original-title="移除"  src="img/remove.png" alt=""></a>
                        </td>

                    </tr>
                  </c:forEach>
                </table>
            </div>
            <%--暂时无用--%>
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
            <%--暂时无用--%>
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
                                <td><span class="bold totalamout" id="total">￥${sessionScope.forder.total}</span></td>
                            </tr>
                        </table>
                        <%--<input type="submit" value="结账" class="btn btn-orange pull-right">--%>
                        <button class="btn btn-orange pull-right">
                            <font><a href="${shop}/user/confirm.jsp">确认订单</a></font>
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
<%@include file="public/htmlfooter.jsp"%>
</body>
</html>
