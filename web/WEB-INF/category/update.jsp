<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/21
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/public/head.jsp"%>
    <style style="text/css">
        form div{
            margin: 5px;
        }
    </style>
    <script type="text/javascript">
        var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
        var rows=dg.datagrid("getSelections");
        $('#form').form('load',{
            id:rows[0].id,
            type:rows[0].type,
            hot:rows[0].hot,
        });


//        $(function(){
//            $("[name=type]").validatebox({
//                required:true,
//                invalidMessage:'对不起此类别已存在'
//            });
//            $("#submit").click(function(){
//                $("#ff").form("enableValidation");
//                // 默认是ajax提交,提交之前会自动进行表达验证
//                $('#ff').form('submit', {
//                    url:'Category_save.action',
//                    success:function(result){
//                        // 如果成功 则重置表单数据
//                        parent.$("#window").window("close");
//                        parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload")
//                        $("#ff").form("disableValidation");
//                        $("#ff").form("reset");
//                    }
//                });
//            });
//            $("#reset").click(function(){
//                $("#ff").form("reset");
//            });
//            $("#ff").form("disableValidation");
//        });
    </script>
</head>
<body>
<form id="form" method="post">
    <div>
        <label for="type">类型</label>
        <input class="easyui-validatebox" type="text" name="type" />
    </div>
    <div>
        <label for="hot">热点</label>
        是：<input  type="radio" name="hot" value="true" />
        否：<input  type="radio" name="hot" value="false"  checked="checked"/>
    </div>
    <div>
        <label for="account">所属管理员</label>
        <select id="cc" class="easyui-combobox" name="account" style="width:200px;">
            <option value="aa">aitem1</option>
            <option>bitem2</option>
            <option>bitem3</option>
            <option>ditem4</option>
            <option>eitem5</option>
        </select>
    </div>
    <div>
        <input type="hidden" name="id"/>
        <a id="submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">更新类别</a>
        <a id="reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">重置</a>
    </div>
</form>
</body>
</html>
