<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/22
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="/public/head.jsp"%>
    <style type="text/css">
        body{
            margin: 1px;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $("#dg").datagrid({
                url:'Product_queryJoinCategory.action',
                queryParams:{name:""}, //第一查询的时候发出额外参数
                idField:'id',
                autoRowHeight:false,   // 固定高度
                striped:true,
                nowrap:true,  //如果为true，则在同一行中显示数据
                loadMsg:"正在加载......",
                singleSelect:false, // 支持单行显示
                rownumbers:true,  //显示行号
                fitColumns:true,
                pagination:true, //是否支持分页显示
                pageNumber:1,  //初始页码
                pageSize:5,   // 每页显示的记录数
                pageList:[5,10,15,20],   // 初始化页面大小选择列表
                toolbar:[{
                    iconCls: 'icon-save',
                    text:'添加商品',
                    handler: function(){
                        parent.$("#window").window({
                            title:"添加商品",
                            width:500,
                            height:400,
                            content:'<iframe src="Send_product_save.action" frameborder="0" width="100%" height="100%"/>'
                        })
                    }
                },'-',{
                    iconCls: 'icon-edit',
                    text:'更新商品',
                    handler: function(){
                        var rows=$("#dg").datagrid("getSelections");
                        if (rows.length!=1){
                            $.messager.show({
                                title:'错误提示',
                                msg:'每次更新一条数据',
                                timeout:2000,
                                showType:'slide'
                            })
                        }else {
                            parent.$("#updatewindow").window({
                                title:"更新类别",
                                width:500,
                                height:400,
                                content:'<iframe src="Send_product_update.action" frameborder="0" width="100%" height="100%"/>'
                            })
                        }
                    }
                },'-',{
                    iconCls: 'icon-remove',
                    text:'删除商品',
                    handler: function(){
                        var rows=$('#dg').datagrid("getSelections");
                        if (rows.length==0){
                            $.messager.show({
                                title:'操作错误',
                                msg:'至少选择一条记录。',
                                timeout:2000,
                                showType:'slide'
                            });
                        }else {
                            $.messager.confirm('确认', '确定删除？', function(r){
                                if (r){
//                                    1.获取被选中的记录，并判断获取相应id
                                    var ids="";
                                    for(var i=0;i<rows.length;i++){
                                        ids+=rows[i].id+","
                                    }
//                                    2.多条件删除拼接id值
                                    ids=ids.substring(0,ids.lastIndexOf(","));
//                                     3.发送Ajax请求
                                    $.post("Product_deleteByIds.action",{ids:ids},function (result){
                                        if(result=="true"){
                                            $("#dg").datagrid("uncheckAll")
                                            $("#dg").datagrid("reload")
                                        }else {
                                            $.messager.show({
                                                title:'删除异常',
                                                msg:'删除失败。',
                                                timeout:2000,
                                                showType:'slide'
                                            });
                                        }
                                    },"text");
                                }
                            });
                        }
                    }
                },'-',{
                    text:"<input id='search' name='type' />"
                }],
                columns:[[
                    {field:'zz',checkbox:'true',width:200,align:'right'},
                    {field:'id',title:'编号',width:200},
                    {field:'name',title:'商品名称',width:200},
                    {field:'count',title:'商品数量',width:200},
                    {field:'price',title:'价格',width:200,align:'right'},
                    {field:'remark',title:'简单介绍',width:200,align:'left'},    		         {field:'type',title:'所属类别',width:200,align:'right',
                        formatter: function(value,row,index){
                            if(row.category!=null)
                                return row.category.type;
                        }
                    }
                ]]
            });
            $("#search").searchbox({
                // 响应搜索的事件
                searcher:function(value,name){
                    $('#dg').datagrid(
                            'load',{
                                type:value
                            }
                    )
                },
                prompt:'Please Input Value'
            });
        });
    </script>
</head>
<body>
<table id="dg"></table>
</body>
</html>
