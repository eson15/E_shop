<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf" %>
</head>
<!-- 框架体，里面包含了3+1个页面 -->
<frameset border="5" rows="150,*">
	<frame src="send_main_top.action" />
	<frameset border="5" cols="150,*">
		<frame src="send_main_left.action" />
		<frame src="send_main_right.action" />
	</frameset>
</frameset>  

</html>