<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
</head>

	<body class="easyui-layout">
	    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
	    <div data-options="region:'west',title:'West',split:true" style="width:200px;">
	    	<!-- 此处显示的是系统菜单 -->
	    	<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">   
    			<div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
        			<h3 style="color:#0099FF;">Accordion for jQuery</h3>   
        			<p>Accordion is a part of easyui framework for jQuery.     
        			It lets you define your accordion component on web page more easily.</p>   
    			</div>   
    			<div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">content2</div>   
    			<div title="Title3">content3</div>   
			</div>   
	    </div>   
	    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
	</body>  

</html>