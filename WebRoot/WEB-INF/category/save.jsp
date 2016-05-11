<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		form div {
			margin:5px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$("input[name=type]").validatebox({
				required:true,
				missingMessage:'请输入类别名称'
			});	
			
			//对管理员的下拉列表框进行远程加载
			$("#cc").combobox({   
				//将请求发送给accountAction中的query方法处理，这里需要将处理好的数据返回到这边来显示了 ，所以后台需要将数据打包成json格式发过来
			    url:'account_query.action',  
			    valueField:'id',    
			    textField:'login', //我们下拉列表中显示的是管理员的登录名
			    panelHeight:'auto', //自适应高度
			    panelWidth:120,//下拉列表是两个组件组成的
			    width:120, //要同时设置两个宽度才行
			    editable:false //下拉框不允许编辑
			});

			//窗体弹出默认时禁用验证
			$("#ff").form("disableValidation");
			//注册button的事件
			$("#btn").click(function(){
				//开启验证
				$("#ff").form("enableValidation");
				//如果验证成功，则提交数据
				if($("#ff").form("validate")) {
					//调用submit方法提交数据
					$("#ff").form('submit', {
						url: 'category_save.action',
						success: function(){
							//如果成功了，关闭当前窗口
							parent.$("#win").window("close");
							//刷新页面 :获取aindex-->iframe-->datagrid
							//这里有点难理解
							//var dg = parent.$("iframe[title='类别管理']").contains().find("#dg").datagrid("reload");
							parent.$("iframe[title='类别管理']").get(0).contentWindow.$("#dg").datagrid("reload");
							//alert(dg);
						}
					});
				}
			});
		});
	</script>
  </head>
  
  <body>
  	<form id="ff" method="post">   
	    <div>   
	        <label for="name">类别名称:</label> <input type="text" name="type" />   
	    </div>   
	    <div>
			<label>所属管理员：</label> 
			<input id="cc" name="account.id"/>
		</div>
	    <div>   
	        <label for="hot">热点:</label>   
	        	是<input type="radio" name="hot" value="true" />&nbsp;
	        	否 <input type="radio" name="hot" value="true" />
	    </div>  
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
	    </div>  
	</form>  	
  </body>
</html>