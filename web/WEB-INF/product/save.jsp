<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/22
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/public/head.jsp"%>
    <style type="text/css">
        form div{
            margin: 10px;
        }
    </style>
    <script type="text/javascript">

        $(function(){
            $("#cate").combobox({
                url:'Category_query.action',
                panelHeight:"auto",
                valueField:'id',
                textField:'type',
                paneHeight:'auto',
                editable:false,
                paneWidth:200,
                required:true,
                missingMessage:"情选择所属类型"
            });
            $("#size").combobox({
                url:'Size_query.action',
                panelHeight:"auto",
                valueField:'sizename',
                textField:'sizename',
                multiple:true,
                paneHeight:'auto',
                editable:false,
                paneWidth:200,
                required:true,
                missingMessage:"情选择产品类型"
            });
            $("#color").combobox({
                url:'Color_query.action',
                panelHeight:"auto",
                valueField:'colorname',
                textField:'colorname',
                multiple:true,
                paneHeight:'auto',
                editable:false,
                paneWidth:200,
                required:true,
                missingMessage:"情选择产品类型"
            });
            $(function(){
            $.extend($.fn.validatebox.defaults.rules,{
                format:{
                    validator: function (value, param) {
                        var  ext=value.substring(value.lastIndexOf('.')+1);
                        var arr=param[0].split(',');
                        for(var i=0;i<arr.length;i++){
                            if(ext==arr[i])
                                return true;
                        }
                        return false;
                    },
                    message:'文件格式必须为:{0}'
                }
            });
            $("input[name=name]").validatebox({
                required:true,
                missingMessage:'商品名称不能为空'
            });
            $("input[name=count]").numberbox({
                required:true,
                missingMessage:'数量不能为空',
                min:0,
                precision:0
            });
            $("textarea[name=remark]").validatebox({
                required:true,
                missingMessage:'商品简介不能为空'
            })
           $('#discount').numberbox({
               min:0,
               max:100,
               suffix:'%'
           })
                $('#star').numberbox({
                   min:1,
                   max:5,
                    required:true,
                    missingMessage:'推荐指数不能为空'
                 })
            $('#price').numberbox({
                required:true,
                missingMessage:'价格不能为空',
                min:0,
                precision:2,
                prefix:'￥'
            });
            $('input[name="fileImage.upload"]').validatebox({
                required:true,
                missingMessage:'请上传商品文件',
                validType:'format["gif,jpg,jpeg,png"]'
            });
            $('input[name="fileImage.upload"]').change(function () {
                $(this).validatebox("validate");
            });

            $("#submit").click(function(){
                $("#ff").form("enableValidation");
                // 默认是ajax提交,提交之前会自动进行表达验证
                $('#ff').form('submit', {
                    url:'Product_save.action',
                    success:function(result){
                        // 如果成功 则重置表单数据
                        parent.$("#window").window("close");
                        parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid("reload");
                        $("#ff").form("disableValidation");
                        $("#ff").form("reset");
                    }
                });
            });
            $("#reset").click(function(){
                $("#ff").form("reset");
            });
            $("#ff").form("disableValidation");
        });
        });
    </script>
</head>
<body>
<form title="添加商品" id="ff" method="post" enctype="multipart/form-data" >
    <div>
        <label>商品名称:</label> <input class="easyui-validatebox" type="text" name="name" />
    </div>
    <div>
        <label>推荐指数:</label> <input id="star" class="easyui-validatebox" type="text" name="star" />
    </div>
    <div>
        <label>商品价格:</label> <input id="price" class="easyui-validatebox" type="text" name="price" />
    </div>
    <div>
        <label>商品数量:</label> <input id="count" class="easyui-validatebox" type="text" name="count" />
    </div>
    <div>
        <label>商品折扣:</label> <input id="discount" class="easyui-validatebox" type="text" name="discount" />
    </div>
    <div>
        <label>图片上传:</label> <input class="easyui-validatebox" type="file" name="fileImage.upload" />
    </div>

    <div>
        <label>所属类别：</label>
        <input id="cate" name="category.id">
    </div>
    <div>
        <label>产品尺寸：</label>
        <input id="size"  name="size">
    </div>
    <div>
        <label>产品颜色：</label>
        <input id="color"  name="color">
    </div>
    <div>
        <label>加入推荐:</label> 推荐:<input type="radio" name="commend"
                                       checked="checked" value="true" />
                                 不推荐:<input type="radio" name="commend" value="false" />
    </div>
    <div>
        <label>是否有效:</label>
        上架:<input type="radio" name="open" checked="checked"value="true" />
        下架:<input type="radio" name="open" value="false" />

    </div>
    <div>
        <label>简单描述:</label>
        <textarea class="easyui-validatebox" name="remark" cols="40" rows="4"></textarea>
    </div>
    <div>
        <label>详细描述:</label>
        <textarea name="xremark" cols="40" rows="8"></textarea>
    </div>
    <div>
        <a id="submit" href="#" class="easyui-linkbutton">添 加</a>
        <a id="reset" href="#" class="easyui-linkbutton">重 置</a>
    </div>
    </form>
</body>
</html>
