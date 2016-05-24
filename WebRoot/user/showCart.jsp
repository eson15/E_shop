<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
			//注册事件
			$(".text").change(function(){
			//验证数据的有效性
				var number = this.value; //也可以使用$(this).val();
				//isNaN(number)表示若number不是数字就返回真
				if(!isNaN(number) && parseInt(number)==number && number>0){ 
					//如果合法，同步更新的数
					$(this).attr("lang", number);
					//找到当前标签中第一个是tr的父节点，然后拿到属性为lang的值，也就是商品的id
					var pid = $(this).parents("tr:first").attr("lang");
					//发送Ajax请求，传输当前的数量与商品的id，返回修改数量后的总价格
					$.post("sorder_updateSorder.action", {number:number, 'product.id':pid}, function(total){		
						$("#total").html(total); //所有商品的小计
						var yunfei = $("#yunfei").html();
						$("#totalAll").html((total*1 + yunfei*1).toFixed(2)); //所有商品小计和运费的和
					}, "text");
					//计算单个商品的小计，保留两位小数
					var price = ($(this).parent().prev().html()*number).toFixed(2);
					$(this).parent().next().html(price);
				} else {
					//如果非法，还原为刚刚合法的数
					this.value = $(this).attr("lang");
				}
			})
		})
	</script>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="header_container">
				<!--头部开始-->
				<div class="top_bar clear">
					<!--头部小导航-->
					<div class="welcom fl">欢迎光临LEISUPET SHOP!</div>
					<ul class="top_links fr">
						<li><a href="#">首页</a></li>
						<li><a href="#">我的账户</a></li>
						<li class="highlight"><a href="#">购物车</a></li>
						<li><a href="#">注册</a></li>
						<li><a href="#">登录</a></li>
					</ul>
					<!--头部小导航结束-->
					<!-- logo -->
					<h1 class="logo clear fl">
						<a href="index.html"> <img src="images/logo.png" /> </a>
					</h1>
					<!-- 小购物车 -->
					<div class="minicart">
						<a class="minicart_link" href="#"> <span class="item">
								<b>${fn:length(sessionScope.forder.sorders)}</b> 件/ </span> 
								<span class="price"> <b>￥${sessionScope.forder.total}</b> </span> </a>
					</div>
					<!-- 小购物车结束 -->
					<!-- 搜索框 -->
					<div class="header_search">
						<div class="form-search ">
							<input value="请输入商品名称" class="input-text" type="text" />
							<button type="submit" title="Search"></button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		<div class="navigation_container">
			<!---->
			<div class="nav">
				<ul class="primary_nav">
					<li class="active highlight"><a href="#">女装</a> <!--二级菜单-->
						<ul class="sub_menu">
							<li><a href="#">裙装</a>
								<ul>
									<li><a href="#">短裙</a></li>
									<li><a href="#">短裤</a></li>
									<li><a href="#">裤子</a></li>
									<li><a href="#">卡其裤</a></li>
									<li><a href="#">休闲裤</a></li>
									<li><a href="#">牛仔裤</a></li>
									<li><a href="#">风衣  运动夹克</a></li>
								</ul></li>
							<li><a href="#">装饰品</a>
								<ul>
									<li><a href="#">太阳镜</a></li>
									<li><a href="#">围巾</a></li>
									<li><a href="#">发饰品</a></li>
									<li><a href="#">帽子和手套</a></li>
									<li><a href="#">生活时尚</a></li>
									<li><a href="#">牛仔系列</a></li>
									<li><a href="#">风衣  西服</a></li>
								</ul></li>
						</ul></li>
					<!--二级菜单结束-->
					<li><a href="#">男装</a> <!--二级菜单-->
						<ul class="sub_menu">
							<li><a href="#">男士夏装</a>
								<ul>
									<li><a href="#">裤子</a></li>
									<li><a href="#">休闲裤</a></li>
									<li><a href="#">卡其裤</a></li>
									<li><a href="#">牛仔裤</a></li>
									<li><a href="#">风衣  运动夹克</a></li>
								</ul></li>
							<li><a href="#">装饰品</a>
								<ul>
									<li><a href="#">太阳镜</a></li>
									<li><a href="#">围巾</a></li>
									<li><a href="#">发饰品</a></li>
									<li><a href="#">帽子和手套</a></li>
									<li><a href="#">生活时尚</a></li>
									<li><a href="#">牛仔系列</a></li>
									<li><a href="#">风衣  西服</a></li>
								</ul></li>
						</ul> <!--二级菜单结束--></li>
					<li><a href="#">儿童</a></li>
					<li><a href="#">时尚</a></li>
					<li><a href="#">装饰品</a></li>
				</ul>
			</div>
		</div>
		<!--导航栏结束-->
		<div class="section_container">
			<!-- 购物车 -->
			<div id="shopping_cart">
				<div class="message success">我的购物车</div>
				<table class="data-table cart-table" cellpadding="0" cellspacing="0">
					<tr>
						<th class="align_center" width="10%">商品编号</th>
						<th class="align_left" width="35%" colspan="2">商品名称</th>
						<th class="align_center" width="10%">销售价格</th>
						<th class="align_center" width="20%">数量</th>
						<th class="align_center" width="15%">小计</th>
						<th class="align_center" width="10%">删除</th>
					</tr>
					<c:forEach items="${sessionScope.forder.sorders }" var="sorder" varStatus="num">
					<tr lang="${sorder.product.id}">
						<td class="align_center"><a href="#" class="edit">${num.count }</a>
						</td>
						<td width="80px"><img src="${shop}/files/${sorder.product.pic}" width="80" height="80" />
						</td>
						<td class="align_left"><a class="pr_name" href="#">${sorder.name }</a>
						</td>
						<td class="align_center vline">
							${sorder.price }
						</td>
						<td class="align_center vline">
							<!-- 文本框 -->
							<input class="text" style="height: 20px;" value="${sorder.number }" lang="${sorder.number }">		
						</td>
						<td class="align_center vline">
							${sorder.price*sorder.number }
						</td>
						<td class="align_center vline"><a href="#" class="remove"></a>
						</td>
					</tr>
					</c:forEach>

				</table>
				<!-- 结算 -->
				<div class="totals">
					<table id="totals-table">
						<tbody>
							<tr>
								<td width="60%" colspan="1" class="align_left"><strong>小计</strong>
								</td>
								<td class="align_right" style=""><strong>￥<span
										class="price" id="total">${sessionScope.forder.total}</span>
								</strong>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left">运费</td>
								<td class="align_right" style="">￥<span class="price" id="yunfei">0.00</span>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left total"><strong>总计</strong>
								</td>
								<td class="align_right" style="">￥<span class="total" id="totalAll"><strong>${sessionScope.forder.total}</strong>
								</span>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="action_buttonbar">
						<font><a href="${shop}/user/confirm.jsp">
							<button type="button" title="" class="checkout fr" style="background-color: #f38256;">
									订单确认
							</button>
						</a></font>
						<button type="button" title="" class=" fr">
							<font><font>清空购物车</font>
							</font>
						</button>
						<a href="${shop}/index.jsp">
							<button type="button" title="" class="continue fr">
								<font>继续购物</font>
							</button></a>
						<div style="clear:both"></div>
					</div>
				</div>
			</div>
			<!-- 导航栏结束 -->
			<div class="footer_container">
				<div class="footer">
					<ul class="footer_links">
						<li><span>收藏本店</span>
							<ul>
								<li><a href="#">服装</a></li>
								<li><a href="#">鞋子</a></li>
								<li><a href="#">包包</a></li>
								<li><a href="#">装饰品</a></li>
								<li><a href="#">channel</a></li>
								<li><a href="#">prada</a></li>
								<li><a href="#">LV</a></li>
							</ul></li>
						<li class="seperator"><span>出售的品牌</span>
							<ul>
								<li><a href="#">Elle</a></li>
								<li><a href="#">Reallxe</a></li>
								<li><a href="#">Fabric</a></li>
								<li><a href="#">Mayflower</a></li>
								<li><a href="#">Levis Strauss</a></li>
								<li><a href="#">Anzonica</a></li>
								<li><a href="#">Reallxe</a></li>
								<li><a href="#">Fabric</a></li>
							</ul></li>
						<li><span>客户服务</span>
							<ul>
								<li><a href="#">帮助</a></li>
								<li><a href="#">速递</a></li>
								<li><a href="#">退换货</a></li>
								<li><a href="#">付款方式</a></li>
								<li><a href="#">订单跟踪</a></li>
								<li><a href="#">礼物包选项</a></li>
								<li><a href="#">国际服务</a></li>
								<li><a href="#">退运险</a></li>
							</ul></li>
						<li><span>个人账户</span>
							<ul>
								<li><a href="#">个人账户信息</a></li>
								<li><a href="#">用户密码</a></li>
								<li><a href="#">订单历史</a></li>
								<li><a href="#">付款方式</a></li>
								<li><a href="#">我的收货地址</a></li>
								<li><a href="#">我的通知</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
