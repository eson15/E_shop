package cn.it.shop.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
/**
 * @Description: TODO(用于项目启动的时候数据初始化)
 * @author Ni Shengwu
 *
 */
//@Component //监听器是web层的组件，它是tomcat实例化的，不是Spring实例化的。不能放到Spring中
public class InitDataListener implements ServletContextListener {
	
	private ProductService productService = null;
	private CategoryService categoryService = null;
	private ApplicationContext context = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// 解决方案一，可以加载productService，但是Spring把所有的service都实例化了2次，因为这里又加载了一次。不可取。
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		productService = (ProductService) context.getBean("productService");
//		System.out.println(productService);
//		
		// 解决方案二，项目在启动时，把Spring配置文件通过Spring的监听器加载，存储到ServletContext中，我们只要在ServletContext中获取即可。
		// 此方案的key比较长，不容易记住
//		ApplicationContext context = (ApplicationContext) event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService = (ProductService) context.getBean("productService");
//		System.out.println(productService);
		
		// 解决方案三，通过工具类加载即可
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());		
		categoryService = (CategoryService) context.getBean("categoryService");//加载类别信息		
		productService = (ProductService) context.getBean("productService");//加载商品信息

		List<List<Product>> bigList = new ArrayList<List<Product>>(); //bigList中存放一个装有Category类的list
		// 1. 查询出热点类别
		for(Category category : categoryService.queryByHot(true)) {
			//根据热点类别id获取推荐商品信息
			List<Product> lst = productService.querByCategoryId(category.getId());
			bigList.add(lst); //将装有category的list放到bigList中
		}
		// 2. 把查询的bigList交给application内置对象
		event.getServletContext().setAttribute("bigList", bigList);
	}

}
