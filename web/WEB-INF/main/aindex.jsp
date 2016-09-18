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
            background-color: #2b4490;
            color: #fff;
            padding: 5px;
            text-decoration: none;
        }
        #menu a:hover{
            background-color: #4e72b8;
        }
    </style>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
<div data-options="region:'west',title:'West',split:true" style="width:200px;">
   <%--系统菜单--%>
    <div id="menu" class="easyui-accordion" data-options="fit:true">
        <div title="基本操作" data-options="iconCls:'icon-save'">
             <ul>
                 <li><a href="#">类别管理</a> </li>
                 <li><a href="#">商品管理</a> </li>
             </ul>
        </div>
        <div title="基本操作" data-options="iconCls:'icon-reload',selected:true" >
            <ul>
                <li><a href="#">类别管理</a> </li>
                <li><a href="#">商品管理</a> </li>
            </ul>
        </div>
        <div title="Title3">
            content3
        </div>
    </div>

</div>
<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
</body>
</html>
