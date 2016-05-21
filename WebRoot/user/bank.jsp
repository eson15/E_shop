<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@ include file="/public/head.jspf" %>
  </head>
  <body>
  
  	    <div class="wrapper">
        <div class="header">
            <div class="header_container">
                <!--头部开始-->
                <div class="top_bar clear">
                    <!--头部小导航-->
                    <div class="welcom fl">欢迎光临LEISUPET SHOP!</div>
                    <ul class="top_links fr">
                        <li class="highlight">
                            <a href="#">首页</a>
                        </li>
                        <li>
                            <a href="#">我的账户</a>
                        </li>
                        <li>
                            <a href="#">购物车</a>
                        </li>
                        <li>
                            <a href="#">注册</a>
                        </li>
                        <li >
                            <a href="#">登录</a>
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
                            <span class="item"> <b>2</b>
                                件/
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
                                        <a href="#">风衣 & 运动夹克</a>
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
                                        <a href="#">风衣 & 西服</a>
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
                                        <a href="#">风衣 & 运动夹克</a>
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
                                        <a href="#">风衣 & 西服</a>
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
                <li >
                    <a href="#">确认订单信息</a>
                </li>
                <li class="active">
                    <a href="#">完成订单</a>
                </li>
            </ul>
            <!-- 确认订单信息 -->
            <div class="pay-step">
                <!-- 订购人确认 -->
                <div class="person-check check">
                    <h1>您的订单已经生成</h1>
                    <div class="person-checkinner">
                        <div><span>订单号</span>：<span>${sessionScope.oldForder.id}</span></div>
                        <div><span>收货人</span>：<span>${sessionScope.oldForder.name}</span></div>
                        <div><span>送货地址</span>：<span>${sessionScope.oldForder.address}</span></div>
                        <div><span>邮政编码</span>：<span>${sessionScope.oldForder.post}</span></div>
                        <div><span>支付金额</span>：<span>${sessionScope.oldForder.total}</span></div>
                    </div>
                </div>
                <div class="pay">
                    <div class="pay-inner">
                        <div class="fl">支付方式:</div>
                        <div class="fl yibao-logo">
                             <a href=""><img src="${shop}/files/yibao.jpg" width="110" height="35" alt="" /></a>
                        </div>
                        <div class="fr blue aa">世界一流的电子支付应用和服务提供商
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="red"href="">如何使用?</a>
                        </div>

                    </div>
                </div>
                <div class="select-bank">
                	<form action="${shop}/pay_goBank.action" method="post">
                    <h1>请选择支付银行</h1>
                    <!--  {fn:indexOf(name,'.'))}  {fn:substring(zip, 6, -1)} -->
                    <div>
                        <ul>
                           <c:forEach items="${applicationScope.bankImageList}" var="bankImage">
	                            <li>
	                                <input type="radio" name="pd_FrpId" value="${fn:substring(bankImage, 0, fn:indexOf(bankImage, '.'))}" />&nbsp;
	                                <img src="${shop }/files/bankImages/${bankImage}" />
	                            </li>
                           </c:forEach>
                        </ul>
                    </div>
                    <div class="clear"></div>
                    <div class="reminder"><span>请确保您的银行卡已开通网银支付功能，否则没有办法完成支付&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <a href="">如何开通?</a></div>
                    <div class="pay-submit">
                    	<div class="pay-inner">
                    		<input type="submit" style="width: 80px; height: 40px;" value="确认支付" />
                    	</div>
            		</div>	
                    </form>
                </div>
                
            </div>
            
            

            <div class="footer_container">

                <div class="footer">
                    <ul class="footer_links">
                        <li>
                            <span>收藏本店</span>
                            <ul>
                                <li>
                                    <a href="#">服装</a>
                                </li>
                                <li>
                                    <a href="#">鞋子</a>
                                </li>
                                <li>
                                    <a href="#">包包</a>
                                </li>
                                <li>
                                    <a href="#">装饰品</a>
                                </li>
                                <li>
                                    <a href="#">channel</a>
                                </li>
                                <li>
                                    <a href="#">prada</a>
                                </li>
                                <li>
                                    <a href="#">LV</a>
                                </li>
                            </ul>
                        </li>
                        <li class="seperator">
                            <span>出售的品牌</span>
                            <ul>
                                <li>
                                    <a href="#">Elle</a>
                                </li>
                                <li>
                                    <a href="#">Reallxe</a>
                                </li>
                                <li>
                                    <a href="#">Fabric</a>
                                </li>
                                <li>
                                    <a href="#">Mayflower</a>
                                </li>
                                <li>
                                    <a href="#">Levis Strauss</a>
                                </li>
                                <li>
                                    <a href="#">Anzonica</a>
                                </li>
                                <li>
                                    <a href="#">Reallxe</a>
                                </li>
                                <li>
                                    <a href="#">Fabric</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <span>客户服务</span>
                            <ul>
                                <li>
                                    <a href="#">帮助</a>
                                </li>
                                <li>
                                    <a href="#">速递</a>
                                </li>
                                <li>
                                    <a href="#">退换货</a>
                                </li>
                                <li>
                                    <a href="#">付款方式</a>
                                </li>
                                <li>
                                    <a href="#">订单跟踪</a>
                                </li>
                                <li>
                                    <a href="#">礼物包选项</a>
                                </li>
                                <li>
                                    <a href="#">国际服务</a>
                                </li>
                                <li>
                                    <a href="#">退运险</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <span>个人账户</span>
                            <ul>
                                <li>
                                    <a href="#">个人账户信息</a>
                                </li>
                                <li>
                                    <a href="#">用户密码</a>
                                </li>
                                <li>
                                    <a href="#">订单历史</a>
                                </li>
                                <li>
                                    <a href="#">付款方式</a>
                                </li>
                                <li>
                                    <a href="#">我的收货地址</a>
                                </li>
                                <li>
                                    <a href="#">我的通知</a>
                                </li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
  </body>
</html>
