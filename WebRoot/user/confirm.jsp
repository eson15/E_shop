<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>
	  <% response.setHeader("cache-control", "no-store"); %>	
  </head>
  <body>
  	 <c:if test="${empty sessionScope.forder.sorders }">
  	 	<!-- 如果购物车中的购物项为空，则跳转到首页 -->
  	 	<c:redirect url="/index.jsp"/>
  	 </c:if>
  	 <div class="wrapper">
        <div class="header">
            <div class="header_container">
                <!--头部开始-->
                <div class="top_bar clear">
                    <!--头部小导航-->
                    <div class="welcom fl">欢迎光临LEISUPET SHOP!</div>
                    <ul class="top_links fr">
                        <li>
                            <a href="${shop}/index.jsp">首页</a>
                        </li>
                        <li>
                            <a href="#">我的账户</a>
                        </li>
                        <li class="highlight">
                            <a href="#">购物车</a>
                        </li>
                        <li>
                            <a href="#">欢迎您：${user.name }</a>
                        </li>
                    </ul>
                    <!--头部小导航结束-->
                    <!-- logo -->
                    <h1 class="logo clear fl">
                        <a href="index.html">
                            <img src="images/logo.png" />
                        </a>
                    </h1>
                    <!-- 小购物车 -->
                    <div class="minicart">
                        <a class="minicart_link" href="#">
                            <span class="item"> <b>2</b> 件/
                            </span>
                            <span class="price"> <b>￥199.80</b>
                            </span>
                        </a>
                    </div>
                    <!-- 小购物车结束 -->
                    <!-- 搜索框 -->
                    <div class="header_search">
                        <div class="form-search ">
                            <input  value="请输入商品名称" class="input-text"  type="text"/>
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
                    <li class="active highlight">
                        <a href="#">女装</a>
                        <!--二级菜单-->
                        <ul class="sub_menu">
                            <li >
                                <a href="#">裙装</a>
                                <ul>
                                    <li>
                                        <a href="#">短裙</a>
                                    </li>
                                    <li>
                                        <a href="#">短裤</a>
                                    </li>
                                    <li>
                                        <a href="#">裤子</a>
                                    </li>
                                    <li>
                                        <a href="#">卡其裤</a>
                                    </li>
                                    <li>
                                        <a href="#">休闲裤</a>
                                    </li>
                                    <li>
                                        <a href="#">牛仔裤</a>
                                    </li>
                                    <li>
                                        <a href="#">风衣  运动夹克</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">装饰品</a>
                                <ul>
                                    <li>
                                        <a href="#">太阳镜</a>
                                    </li>
                                    <li>
                                        <a href="#">围巾</a>
                                    </li>
                                    <li>
                                        <a href="#">发饰品</a>
                                    </li>
                                    <li>
                                        <a href="#">帽子和手套</a>
                                    </li>
                                    <li>
                                        <a href="#">生活时尚</a>
                                    </li>
                                    <li>
                                        <a href="#">牛仔系列</a>
                                    </li>
                                    <li>
                                        <a href="#">风衣  西服</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <!--二级菜单结束-->

                    <li>
                        <a href="#">男装</a>
                        <!--二级菜单-->
                        <ul class="sub_menu">
                            <li>
                                <a href="#">男士夏装</a>
                                <ul>
                                    <li>
                                        <a href="#">裤子</a>
                                    </li>
                                    <li>
                                        <a href="#">休闲裤</a>
                                    </li>
                                    <li>
                                        <a href="#">卡其裤</a>
                                    </li>
                                    <li>
                                        <a href="#">牛仔裤</a>
                                    </li>
                                    <li>
                                        <a href="#">风衣  运动夹克</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">装饰品</a>
                                <ul>
                                    <li>
                                        <a href="#">太阳镜</a>
                                    </li>
                                    <li>
                                        <a href="#">围巾</a>
                                    </li>
                                    <li>
                                        <a href="#">发饰品</a>
                                    </li>
                                    <li>
                                        <a href="#">帽子和手套</a>
                                    </li>
                                    <li>
                                        <a href="#">生活时尚</a>
                                    </li>
                                    <li>
                                        <a href="#">牛仔系列</a>
                                    </li>
                                    <li>
                                        <a href="#">风衣  西服</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <!--二级菜单结束--> </li>
                    <li>
                        <a href="#">儿童</a>
                    </li>
                    <li>
                        <a href="#">时尚</a>
                    </li>
                    <li>
                        <a href="#">装饰品</a>
                    </li>
                </ul>
            </div>
        </div>
        <!--导航栏结束-->

        <div class="section_container">
            <!-- 购物车 -->
            <ul class="breadcrumb">
                <li>
                    <a href="#">加入购物车</a>
                </li>
                <li class="active">
                    <a href="#">确认订单信息</a>
                </li>
                <li >
                    <a href="#">完成订单</a>
                </li>
            </ul>
            <!-- 确认订单信息 -->
            <div class="check-stup">
            	<!-- 商品确认 -->
                <div class="pro-check check ">
                    <h1>确认订单信息</h1>
	                <table class="data-table cart-table" cellpadding="0" cellspacing="0">
						<tr>
							<th class="align_center" width="10%">商品编号</th>
							<th class="align_left" width="35%" colspan="2">商品名称</th>
							<th class="align_center" width="10%">销售价格</th>
							<th class="align_center" width="20%">数量</th>
							<th class="align_center" width="15%">小计</th>
						</tr>
						<c:forEach items="${sessionScope.forder.sorders}" var="sorder" varStatus="num">
						<tr lang="${sorder.product.id}">
							<td class="align_center"><a href="#" class="edit">${num.count}</a>
							</td>
							<td width="80px"><img src="${shop}/files/${sorder.product.pic}" width="80"
								height="80" />
							</td>
							<td class="align_left"><a class="pr_name" href="#">${sorder.name}</a>
							</td>
							<td class="align_center vline">￥ ${sorder.price}</td>
							<td class="align_center vline">
								${sorder.number}	
							</td>
							<td class="align_center vline">￥${sorder.price*sorder.number}</td>
						</tr>
						</c:forEach>
					</table>
					
                    <div class="sum"> 
                        <div class="fr"><span>总计：</span><b>￥${forder.total}</b></div>
                    </div>
                   
                </div>
                <!-- 订购人确认 -->
                <form action="${shop}/forder_save.action" method="post">
	                <div class="person-check check">
	                    <h1>订购人信息</h1>
	                    <div class="person-checkinner">
	                        <div>
	                        	<label>配送姓名:</label>
	                        	<input type="text" name="name" value="${sessionScope.user.name }"/>
	                        </div>
	                        <div>
	                        	<label>联系方式:</label>
	                        	<input type="text" name="phone" value="${sessionScope.user.phone }"/>
	                        </div>
	                        <div>
	                        	<label>区域邮编:</label>
	                        	<input type="text" name="post" value="${sessionScope.user.phone }"/>
	                        </div>
	                        <div>
	                        	<label>配送地址:</label>
	                        	<input type="text" name="address" />
	                        </div>
	                    </div>
	                </div>
	                <!-- 卖家留言 -->
	                <div class="person-check check">
	               		<h1>卖家留言</h1>
	                	<textarea style="margin: 5px;" name="remark" cols="120" rows="2">输入留言信息</textarea>
		                <div class="submit">
		                   	<input type="submit" class="sub-logo fr" style="margin: 0px;padding: 0px; border: 0px;" value="确认无误,购买" />
		                </div>
	                </div>
                </form>
           </div>
       </div>
      </div>
       <!-- 确认订单信息结束 -->
  </body>
</html>
