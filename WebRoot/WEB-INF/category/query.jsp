<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="/public/head.jspf" %>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({   
				//url地址改为请求categoryAction
			    url:'category_queryJoinAccount.action',
			    loadMsg:'Loading......',
			    queryParams:{type:''},//type参数，这里不需要传具体的type，因为我们要显示所有的
			    //width:300,
			    fitColumns:true,//水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置
			    //显示斑马线
			    striped:true,
			    //当数据多的时候不换行
			    nowrap:true,
			    singleSelect:true, //如果为真，只允许单行显示，全显功能失效
			    //设置分页
			    pagination:true,
			    rowStyler: function(index,row){
			    	console.info("index" + index + "," + row)
			    	if(index % 2 == 0) {
			    		return 'background-color:#fff;';
			    	} else {
			    		return 'background-color:#c4e1e1;';
			    	}
			    	
			    },
			    //同列属性，但是这些列将会冻结在左侧,大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内
			    frozenColumns:[[
			        {field:'checkbox',checkbox:true},
					{field:'id',title:'编号',width:200}    //这里的field字段要和数据库中的一样，也就是要跟json数据中的一样             
			    ]],
			    //配置datagrid的列字段 
			    //field：列字段的名称，与json的key捆绑
			    //title：列标题，是显示给人看的
			    columns:[[    		           
			        {field:'type',title:'类别名称',width:100, //字段type
			        	//用来格式化当前列的值，返回的是最终的数据
			        	formatter: function(value,row,index){
							return "<span title=" +　value + ">" + value + "</span>";
						}
					},    
			        {field:'hot',title:'热卖',width:100,  //字段hot
						formatter: function(value,row,index){
							if(value) {
								return "<input type='checkbox' checked='checked' disabled='true'";
							} else {
								return "<input type='checkbox' disable='true'";
							}
						}
						/*styler: function(value,row,index){
							//设置当前单元格的样式，返回的字符串直接交给 style属性
							console.info("val:" + value + ",row:" + row + ",index:" + index)
							if (value < 20){
								return 'color:red;';
							}
						}*/	
			        },
			        {field:'account.login',title:'所属管理员',width:200, //account.login管理员登录名
			        	formatter: function(value,row,index){
			        		//console.info(row.type + "," + row.account.login);
			        		//return "x";
			        		if(row.account != null && row.account.login != null) {
			        			return row.account.login; //如果登录名不为空，显示登录名
			        		} else {
			        			return "此类别没有管理员";
			        		}
							//return "<span title=" +　value + ">" + value + "</span>";
						}	
			        }
			    ]]    
			}); 
		});
	</script>
  </head>
  
  <body>
  	<table id="dg"></table>
  </body>
</html>