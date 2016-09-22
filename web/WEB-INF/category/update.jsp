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
        $(function () {
            $("#acc").combobox({
                url:'Account_query.action',
                panelHeight:"auto",
                valueField:'id',
                textField:'login',
                paneHeight:'auto',
                editable:false,
                paneWidth:200
            });
            var dg=parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg");
            var rows=dg.datagrid("getSelections");
            $("#ff").form("load",{
                id:rows[0].id,
                type:rows[0].type,
                hot:rows[0].hot,
                'account.id':rows[0].account.id
            });
            $("[name=type]").validatebox({
                required:true,
                missingMessage:'请输入类别'
            });
            $("#submit").click(function(){
                $("#ff").form("enableValidation");
                // 默认是ajax提交,提交之前会自动进行表达验证
                $('#ff').form('submit', {
                    url:'Category_update.action',
                    success:function(result){
                        // 如果成功 则重置表单数据
                        parent.$("#updatewindow").window("close");
                        dg.datagrid("reload");
                        $("#ff").form("disableValidation");

                    }
                });
            });
        })
    </script>
</head>
<body>
<form id="ff" method="post">
    <div>
        <label for="type">类型:</label>
        <input id="type" class="easyui-validatebox" type="text" name="type" />
    </div>
    <div>
        <label for="hot">热点：</label>
        是：<input id="hot" type="radio" name="hot" value="true" />
        <label for="hot">热点：</label>
        否：<input  type="radio" name="hot" value="false"  checked="checked"/>
    </div>
    <div>
        <label for="acc">管理员：</label>
        <input id="acc" name="account.id">
    </div>
    <div>
        <input type="hidden" name="id"/>
        <a id="submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">更新类别</a>
        <a id="reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">重置</a>
    </div>
</form>
</body>
</html>
