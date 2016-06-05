#基于Struts2+Hibernate4+Spring4+EasyUI+MySQL的网上商城项目实战源码
##我的CSDN博客地址：<a href="http://blog.csdn.net/eson_15/" target="blank">http://blog.csdn.net/eson_15/
##0. 写在前面
　　<font size=3>项目基本完成了，与这个项目相关的博客也写了30篇了。总结一下这个网上商城的项目，我不会面面俱到，主要分为几个模块来总结，包括 用到了哪些技术等等，具体的细节我会在文章中附上快速链接，大家可以查看具体的某篇博文。
　　<br/>该项目总共可以分为这些主要的模块：
>- **项目环境的搭建**
>- **搭建后台管理系统**
>- **搭建前台显示页面**
>- **购物车相关功能**
>- **在线支付功能**
>- **邮件和短信的发送功能**
>- **域名的申请和项目的部署**
>- **表单验证和报表的显示**

　　<font size=3>下面针对每个模块，做一下具体的分析。 
##1. 项目环境的搭建
　　<font size=3>这是每个工程都少不了的环节，而且也会出现很多乱七八糟的问题，刚开始学SSH的时候，总是苦于搭建环境，因为不太熟练，但是熟练了就好了，主要是要“有节奏的”去搭建，也就是说搭建一个环境工程得一步步来，很多人上来就把jar包啪叽一下全导进去了，然后什么配置文件啊啪叽一下全写好或者从其他地方粘贴来，然后一运行，挂了……然后各种去找问题，何苦呢？这样的话就算搭建10次也不能得心应手。饭要一口口的吃，路要一步一步的走。　　
　　<br/>　　SSH的环境搭建，我个人遵循的流程是：
>Spring --> Hibernate --> Spring整合Hibernate --> Struts2 --> Spring整合Struts2

　　<font size=3>每一步做完写个测试类测试一下，这很重要，因为一步步往下走的话，出错了也知道错在哪一步，去哪找问题，最重要的是，这种流程熟练了，下次再搭环境的时候就易如反掌了。关于SSH环境搭建的详细信息请看下面的博文：　　
    <br/>[整合Struts2、Hibernate4.3和Spring4.2](http://blog.csdn.net/eson_15/article/details/51277324)
　　<br/>[基本增删查改、Service和Action的抽取以及使用注解替换xml](http://blog.csdn.net/eson_15/article/details/51297698)
##2. 搭建后台管理系统
　　<font size=3>后台管理系统我用的是EasyUI搭建的，说真的，EasyUI我也是一知半解，前端的东西我了解的都不深，但是懂一点，具体用的时候也是各种去查的，也没系统的学过，所以没有一个良好的知识体系，但是也不影响去玩。程序猿都喜欢说玩一个技术啥的，听起来好像挺高大上的，慢慢的我也受到一些影响，也喜欢这么说了，不过我对于前端就真的在玩了……　　
　　<br/><font size=3>jQuery EasyUI是一组基于jQuery的UI插件集合体，而jQuery EasyUI的目标就是帮助web开发者更轻松的打造出功能丰富并且美观的UI界面。开发者不需要编写复杂的javascript，也不需要对css样式有深入的了解，开发者需要了解的只有一些简单的html标签。　　
　　<br/>　　<font size=3>EasyUI的请求都是Ajax请求，不会有新的页面出来，全都都在tab选项卡中或者弹出一个窗口之类的。后台管理系统主要分为三部分：商品的类别管理、商品的管理以及销售管理。销售管理放在最后再说。
###**<font size=4>2.1 商品类别的管理**
　　<font size=3>该部分主要涉及到了**EasyUI环境和后台框架的搭建**、**数据库的级联查询和分页**、**DataGrid数据显示**、**Struts2整合json**以及**商品类别的添加、删除、更新和搜索**。这也是遵循了该部分的一个完成的顺序。　　
　　<br/>　　<font size=3>DataGrid以表格的形式展示数据，开发人员不需要具备特定的知识就可以操作它，它有个很好的帮助文档，比较详细，在本项目中我也介绍了创建DataGrid的几种方式，并且也简单介绍了一下DataGrid的部分属性，算是入门吧，我也是入门，多多开发才能掌握这个技术。　　
　　<br/>　　<font size=3>类别的添加、删除、更新和搜索功能，主要都是利用EasyUI自带的验证功能，添加商品类别的时，验证输入框的输入是否正确，是否必填等；删除时是否先选中的某一行或某几行；更新的时候每次只能更新一行等，所有这些都是Ajax请求。　　
　　<br/>　　关于这部分内容的详细信息，我已经归类了，请参考这些博文：
　　
　　<br/>[使用EasyUI搭建后台页面框架](http://blog.csdn.net/eson_15/article/details/51312490)
　　<br/>[EasyUI菜单的实现](http://blog.csdn.net/eson_15/article/details/51297705)
　　<br/>[数据库的级联查询和分页](http://blog.csdn.net/eson_15/article/details/51320212)
　　<br/>[基于DataGrid的数据显示功能](http://blog.csdn.net/eson_15/article/details/51322262)
　　<br/>[Struts2和Json的整合](http://blog.csdn.net/eson_15/article/details/51332758)
　　<br/>[DataGrid实现查询和删除功能](http://blog.csdn.net/eson_15/article/details/51338991)
　　<br/>[DataGrid实现添加和更新功能](http://blog.csdn.net/eson_15/article/details/51347734)
　　　　
　　<br/>　　下面是我自己遇到的问题：
　　<br/>[Struts2和Json整合中的懒加载异常问题](http://blog.csdn.net/eson_15/article/details/51394302)
　　<br/>[Hibernate4执行save()或update()无效](http://blog.csdn.net/eson_15/article/details/51383298)
###**<font size=4>2.2 商品的管理**
　　<font size=3>商品的管理也有添加删除等操作，跟类别管理道理上是一样的，有个地方就是商品的添加，需要上传商品的照片，这里涉及到了**Struts2实现文件上传**的功能，我们需要在服务器端建一个文件夹专门用来存储上传文件的，然后写一个model来接收文件，关于文件上传，要专门写一个工具类，项目中开发就是这样的，共性的代码一定要抽取，哪怕只有一句代码也要抽取！这是习惯，也是必须要做的。具体细节参下面列出的这些的博文：
　　
　　<br/><font size=3>[商品类基本模块的搭建](http://blog.csdn.net/eson_15/article/details/51354932)
　　<br/>[查询和删除商品功能的实现](http://blog.csdn.net/eson_15/article/details/51360804)
　　<br/>[添加和更新商品功能的实现](http://blog.csdn.net/eson_15/article/details/51366370)
　　<br/>[Struts2实现文件上传功能](http://blog.csdn.net/eson_15/article/details/51366384)
##3. 搭建前台显示页面
　　<font size=3>当然，前台的页面不是我设计的，这一块内容我总结的是跟前台显示相关的一些后台技术，比如：**监听器获取首页数据**、**定时器同步首页数据**、**Hibernate二级缓存处理热门商品的缓存**等。
　　<br/>　　以前在学习serlvet的时候，首页显示数据我是这么干的，用一个frame，右边显示数据，那么index.jsp中右边的部分我跳转到一个servlet，然后servlet中去数据库中取出所有商品，放到request域中带过去新的jsp页面显示。这虽然能实现，但是很笨。在这里我用了监听器来干这件事，首先自己定义一个监听器，在项目启动的时候把数据库中所有商品信息给取出来，放到application域中，然后首页中直接用EL表达式从application域中去取即可。　　
　　<br/>　　还有个问题，当我在管理系统中添加一个新的商品时，我必须要重启一下tomcat才能将新的商品加到application域中，因为第一次取出来后就一直在application域中了，就定死了，后面新添加的就不在application域里面，为了解决这个问题，我使用了定时器来同步首页数据。于是改写了之前写好的监听器，在监听器中设置一个定时器，获取数据库中商品的数据的代码放到定时器任务中，第一次开启立马执行，然后每6个小时执行一次（时间可以自己随便设定），也就是说每6个小时重新获取一下数据库中的商品，存到application域中。一般网站也是这么干的，像CSDN的个人博客主页也是，每天更新一次排名，大概是晚上10点左右吧，具体时间我忘了。那个时候刷新就会看到数据的更新，这样也减小了服务器的压力。

　　<br/>　　<font size=3>该部分具体的技术细节，参见下面这几篇博文：
　　
　　<br/><font size=3>[使用监听器获取显示在首页的数据](http://blog.csdn.net/eson_15/article/details/51373403)
　　<br/>[监听器如何获取Spring的配置文件](http://blog.csdn.net/eson_15/article/details/51373937)
　　<br/>[线程、定时器定时同步首页数据](http://blog.csdn.net/eson_15/article/details/51387378)
　　<br/>[Hibernate二级缓存处理首页的热门显示](http://blog.csdn.net/eson_15/article/details/51405911)
##4. 购物车相关功能
　　<font size=3>购物车的部分主要涉及到的技术有：**后台的处理购物车和购物项的逻辑**、**过滤器判断登陆**、**订单的级联入库**以及**页面缓存**的问题。
　　<br/>　　<font size=3>购物车的话主要是后台的一些实现逻辑了，购物车里需要有购物项，啥意思呢？我们在天猫上买东西都知道，可以把不同的商品都放到购物车里，然后购物车里有很多商品，每个商品的数量又可以有多个，每个商品及其相关信息就是一个购物项，所以添加购物车的时候，我们首先要完成一个购物项，再将此购物项添加到购物车里。
　　<br/>　　<font size=3>当用户想要结算的时候，我们得首先判断用户有没有登陆，这用到了过滤器技术，专门过滤某一类的url，在过滤器中判断当前session中有没有user对象，如果有说明登陆过了，直接放行就行，如果没有则跳转到登陆页面让用户登陆，登陆完成后跳转到用户原来想去的页面。也就相当于门卫一样~看大门的~
　　<br/>　　<font size=3>刚刚也提到了，订单信息包含 购物车和购物项，那么我们在订单入库的时候，就要考虑到它们的级联问题，我们可以通过在两者的POJO中设置相应的注解属性即可，但是有个前提，像这种有外键关联的，在入库之前都要将对应的POJO中的外键部分的字段赋好值，比如订单要将订单项加进去，订单项中的订单属性也得赋好值，然后才可以交给Hibernate，Hibernate根据配置好的注解（或者xml文件）将它们一起级联入库。
　　<br/>　　<font size=3>页面缓存的问题指的是，当用户确认了订单后，如果点后退，又会回到订单确认页面，刚刚的订单确认页面又出来了，而且session还在，信息还是刚刚的信息，这明显不是我们想要的结果。我们需要在前台和后台同时进行处理才行。
　　<br/>　　该部分具体技术细节，请参见下面的几篇博文：

　　<br/><font size=3>[购物车基本功能的实现](http://blog.csdn.net/eson_15/article/details/51418350)
　　<br/><font size=3>[过滤器实现登陆功能的判断](http://blog.csdn.net/eson_15/article/details/51425010)
　　<br/><font size=3>[订单信息的级联入库和页面缓存问题](http://blog.csdn.net/eson_15/article/details/51433247)
##5. 在线支付功能
　　<font size=3>这一部分主要介绍了一些关于易宝支付接口的东西，其实在线支付功能针对不同的第三方都是不一样的，主要是要理解在线支付功能开发的一个流程，具体技术细节得依赖具体的第三方所提供的资料了。但是一般的流程都是：调用第三方的接口 --> 第三方调用银行接口 --> 完成支付 --> 第三方回跳到我们指定的页面。
　　<br/>　　这部分中，还涉及到了一个重要的技术，就是struts2如何处理多个model请求。一般struts2实现了`ModeDriven<model>`后就可以在Action中使用该model，但是现在如果有两个Model咋整呢？在struts2中还有另外一个叫parametersAware接口，只要实现了这个接口，并且定义一个存储参数的Map，就可以接收request请求中的所有参数，我们可以根据不同的参数来判断使用哪个model，这种方法可以很好的解决struts2处理多个model请求问题。
　　<br/>　　关于该部分的技术细节，请参考下列博文：

　　<br/><font size=3>[在线支付平台的介绍](http://blog.csdn.net/eson_15/article/details/51441431)
　　<br/><font size=3>[易宝支付流程的一个demo](http://blog.csdn.net/eson_15/article/details/51447492)
　　<br/><font size=3>[获取银行图标和支付页面的显示](http://blog.csdn.net/eson_15/article/details/51452243)
　　<br/><font size=3>[完成在线支付功能的逻辑](http://blog.csdn.net/eson_15/article/details/51464415)
　　<br/><font size=3>[struts2中如何处理多个model请求](http://blog.csdn.net/eson_15/article/details/51465067)
##6. 邮件和短信的发送功能
　　<font size=3>邮件的发送和短信的发送这一部分相对来说比较简单，都是一些固定的API，会用就行，记不住查查即可，我也记不住。邮件发送功能要导入mail.jar包，然后根据流程发送邮件即可，短信功能首先得去申请一下短信发送功能，申请好了后，第三方就会给我们提供一些API接口，我们只要参考他的就可以开发短信发送功能了，跟支付功能有点类似，都是借助于第三方平台。
　　<br/>　　这部分也没啥技术难点，主要是流程吧，相关的博文如下：

　　<br/><font size=3>[使用java email给用户发邮件](http://blog.csdn.net/eson_15/article/details/51475046)
　　<br/><font size=3>[完成订单支付成功后的短信发送功能](http://blog.csdn.net/eson_15/article/details/51475431)
##7. 域名空间的申请和项目的部署发布
　　<font size=3>这一块主要介绍了如何申请一个免费的域名空间（免费15天而已啦~不过对于学习来说，enough~），虽然不是全部免费的，但是我们主要是要搞清楚这个流程，自己走一遍也好，并不一定要上传完整的工程，一个jsp页面或者html静态页面都行。
　　<br/>　　<font size=3>项目的部署和发布主要有两种方式：一种是使用FTP上传，不过这个比较慢，而且有可能会丢失数据，个人的经验是一点一点的发；还有一种方式就是申请域名空间那里会提供一个部署的环境，我们只要将工程导出为war包，然后把war包部署上去即可。
　　<br/>　　<font size=3>在项目部署之前有很多细节需要注意，比如要修改一些路径啊，要修改一些数据啊等等，这些细节在我的博客里都有详细的说明。该部分就一篇博文，如下：

　　<br/><font size=3>[域名空间的申请和项目的部署发布](http://blog.csdn.net/eson_15/article/details/51484247)

##8. 表单验证和报表的显示
　　<font size=3>后面补充了一些东西，就是**Ajax动态更新购物车中商品的数量**、**表单的验证**和**报表的显示**。
　　<br/>　　Ajax动态更新购物车中商品的数量就是纯粹的Ajax技术，我学习了一下而已，表单的验证主要是登陆表单，这个项目里我没做登陆了，但是登陆表单我做了一个，验证功能也做好了，主要用到的是jQuery的Validate验证插件，这个插件还是很强大的，可以直接将登陆表单加到项目中，设置一下相应的跳转即可。　　报表的显示主要用的是JsChart，这款工具很好用，可以生成响应的js代码，我们要做的就是前台发送Ajax请求给后台，根据实际需求从后台取出数据，传到前台用JsChart图表显示出来即可。
　　<br/>　　该部分的博文，我列出来放在下面：

　　<br/><font size=3>[使用Ajax技术局部更新商品数量和总价](http://blog.csdn.net/eson_15/article/details/51487323)
　　<br/><font size=3>[jQuery-Validate验证插件的使用步骤详解](http://blog.csdn.net/eson_15/article/details/51497533)
　　<br/><font size=3>[使用JsChart技术在后台显示商品销售报表](http://blog.csdn.net/eson_15/article/details/51506334)

　　