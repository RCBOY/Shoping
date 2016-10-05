<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/10/5
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JS Charts</title>
    <%@include file="/public/head.jsp"%>
    <script type="text/javascript" src="${shop}/jquery-easyui-1.5/jscharts.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                $.post($("#sale").val(),{number:$("#number").val()},function (data) {
                    var colorArr=['#CC00FF','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531','#CC00FF'];
                    var myChart = new JSChart('chart_container', $("#type").val(), '');
                    myChart.setDataArray(data);
                    myChart.colorize(colorArr.slice(0,data.length));
                    myChart.setSize(100*$("#number").val(), 300);
                    myChart.setBarValuesFontSize(20);
                    myChart.setBarSpacingRatio(45);
                    myChart.setBarOpacity(1);
                    myChart.setBarBorderWidth(0);
                    myChart.setTitle('商品销量报表');
                    myChart.setTitleFontSize(20);
                    myChart.setTitleColor('#607985');
                    myChart.setAxisValuesColor('#607985');
                    myChart.setAxisNameX('商品', 60);
                    myChart.setAxisNameY('数量', 45);
                    myChart.setGridOpacity(0.8);
                    myChart.set3D(true);
                    myChart.setBarValuesFontSize(15);
                    myChart.setBarValuesFontSize(12);
                    myChart.setBarValuesColor('#000000');
                    myChart.setAxisPaddingLeft(50);
                    myChart.setAxisPaddingBottom(40);
                    myChart.draw();
                },"json")
            })
        })
    </script>
</head>
<body style="margin: 10px">
      请选择报表的类型：
      <select id="sale">
          <option value="Sorder_querySale.action">年度销售报表</option>
      </select> 
      查询的数量：
      <select id="number">
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
      </select>
      报表类型：
      <select id="type">
          <option value="bar">柱状型</option>
          <option value="line">线型</option>
          <option value="pie">饼型</option>
      </select>
      <input type="button" id="submit" value="查询"/>
<div id="chart_container">Loading chart...</div>

</body>
</html>
