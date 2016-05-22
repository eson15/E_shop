package cn.it.shop.listener;

import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.utils.FileUpload;
import cn.it.shop.utils.impl.ProductTimerTask;
/**
 * @Description: TODO(用于项目启动的时候数据初始化)
 * @author Ni Shengwu
 *
 */
//@Component //监听器是web层的组件，它是tomcat实例化的，不是Spring实例化的。不能放到Spring中
public class InitDataListener implements ServletContextListener {
	
	private ApplicationContext context = null;
	private ProductTimerTask productTimerTask = null;
	private FileUpload fileUpload = null;
	
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
		productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");//
		//把内置对象交给productTimerTask
		productTimerTask.setApplication(event.getServletContext());
		//通过设置定时器，让首页的数据每个一小时同步一次（配置为守护线程）
		new Timer(true).schedule(productTimerTask, 0, 1000*60*60);//每个一小时执行一次productTimerTask
		
		//将存储银行图片的数组放到application中，项目启动的时候加载
		fileUpload = (FileUpload) context.getBean("fileUpload");
		event.getServletContext().setAttribute("bankImageList", fileUpload.getBankImage());
	}

}
