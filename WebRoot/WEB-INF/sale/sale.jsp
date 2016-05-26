<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<script type="text/javascript" src="${shop }/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${shop }/js/jscharts.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#submit").click(function(){
				var colorArr = ['#44A622','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531','#E4DB7B'];
				//发送Ajax请求
				$.post($("#sale").val(), {number:$("#number").val()}, function(data){

					var myChart = new JSChart('chart_container', $("#type").val(), '');
					myChart.setDataArray(data);
					myChart.colorize(colorArr.slice(0,data.length));
					myChart.setSize(100*$("#number").val(), 400);
					myChart.setBarValues(false);
					myChart.setBarSpacingRatio(45);
					myChart.setBarOpacity(1);
					myChart.setBarBorderWidth(1);
					myChart.setTitle('商城销售报表');
					myChart.setTitleFontSize(10);
					myChart.setTitleColor('#607985');
					myChart.setAxisValuesColor('#607985');
					myChart.setAxisNameX('商品名称', false);
					myChart.setAxisNameY('销量', true);
					myChart.setGridOpacity(0.8);
					myChart.setAxisPaddingLeft(50);
					myChart.setAxisPaddingBottom(40);
					myChart.set3D(true);
					myChart.draw();
					}, "json");
			});
		});
	</script>
</head>
<body style="margin:10px;">

	请选择报表类型：
	<select id="sale">
		<option value="sorder_querySale.action">年度销售报表</option>
	</select>
	查询数量：
	<select id="number">
		<option value="5">5</option>
		<option value="7">7</option>
		<option value="10">10</option>
	</select>
	类型：
	<select id="type">
		<option value="bar">柱状型</option>
		<option value="line">线型</option>
		<option value="pie">饼状型</option>
	</select>
	<input type="button" id="submit" value="查询">
	<div id="chart_container">Loading Chart...</div>
</body>
</html>