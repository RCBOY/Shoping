<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/18
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/public/head.jsp"%>
    <style type="text/css">
        #menu{
            width: 200px;
        }
        #menu ul{
            list-style:none;
            padding: 0px;
            margin: 0px;
        }
        #menu ul li{
            border-bottom: 1px solid #fff;
        }
        #menu ul li a{
            display: block;
            background-color: #426ab3;
            color: #fff;
            padding: 5px;
            text-decoration: none;
        }
        #menu a:hover{
            background-color: #4e72b8;
        }
    </style>
    <script type="text/javascript">
       $(function () {
           $("a[title]").click(function () {
               var text=$(this).text();
               var href=$(this).attr("title");
               if ($("#tt").tabs("exists",text)){
                   $("#tt").tabs("select",text);
               }else {

                   $("#tt").tabs("add",{
                       title:text,
                       closable:true,
                       content:'<iframe title='+text+' src="'+href+'" frameborder="0" width="100%" height="100%"/>'
//                       href:'Send_category_query.action'
                   });
               }
           })
       })
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'SimpleOne后台管理系统',split:true" style="height:100px;"></div>
<div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
   <%--系统菜单--%>
    <div id="menu" class="easyui-accordion" data-options="fit:true">
        <div  title="基本管理" data-options="iconCls:'icon-save'">
             <ul>
                 <li><a href="#" title="Send_category_query.action">类别管理</a> </li>
                 <li><a href="#" title="Send_product_query.action">商品管理</a> </li>
                 <li><a href="#" title="#">公告管理</a> </li>
             </ul>
        </div>
        <div title="销售管理" data-options="iconCls:'icon-reload',selected:true" >
            <ul>
                <li><a href="#" title="Send_sale_sale.action">销售报表</a> </li>
            </ul>
        </div>
        <div title="用户管理" data-options="iconCls:'icon-reload',selected:true" >
            <ul>
                <li><a href="#" title="#">会员管理</a> </li>
                <li><a href="#">工作人员管理</a> </li>
            </ul>
        </div>


    </div>

</div>
<div data-options="region:'center',title:'后台操作'" style="padding:1px;background:#eee;">
    <div id="tt" class="easyui-tabs" data-options="fit:true">
        <div title="系统缺省页" style="padding:20px;display:none;">
            此处显示系统信息${sessionScope.accountLogin}
        </div>
    </div>
</div>
<div id="window" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"/>
<div id="updatewindow" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"/>
</body>
</html>
