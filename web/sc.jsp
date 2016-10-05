<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1234ztc
  Date: 2016/9/19
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JS Charts</title>
    <script type="text/javascript" src="jscharts.js"></script>
</head>
<body>
<div id="chart_container">Loading chart...</div>
<script type="text/javascript">
    var myChart = new JSChart('chart_container', 'bar', '');
    myChart.setDataArray([['Jun-04', 22.5],['Oct-04', 28],['Feb-05', 32],['Jun-05', 29],['Oct-05', 36],['Feb-06', 42],['Jun-06', 47],['Oct-06', 44],['Feb-07', 49]]);
    myChart.colorize(['#CC00FF','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531']);
    myChart.setSize(550, 300);
    myChart.setBarValuesFontSize(20);
    myChart.setBarSpacingRatio(45);
    myChart.setBarOpacity(1);
    myChart.setBarBorderWidth(0);
    myChart.setTitle('商品月度销售量');
    myChart.setTitleFontSize(20);
    myChart.setTitleColor('#607985');
    myChart.setAxisValuesColor('#607985');
    myChart.setAxisNameX('月份', 60);
    myChart.setAxisNameY('数量', 45);
    myChart.setGridOpacity(0.8);
    myChart.set3D(true);
    myChart.setBarValuesFontSize(15);
    myChart.setBarValuesFontSize(12);
    myChart.setBarValuesColor('#000000');
    myChart.setAxisPaddingLeft(50);
    myChart.setAxisPaddingBottom(40);
    myChart.draw();
</script>
</body>
</html>
