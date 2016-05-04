package cn.it.shop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * Struts执行流程：先创建Action，再调用拦截器，拦截器访问成功再调用Action的方法
 * 在项目启动的时候Struts的过滤器，已经把相应的内置对象，和内置对象对应的Map存储到了ActionContext和值栈中
 * 如果实现了相应的xxxAware接口，就会从ActionContext中获取相应的Map进行传入。实现这个的拦截器为：servletConfig
 * servletConfig：有如下代码：判断当前实现什么接口，则会注入相应的对象
 * if (action instanceof ApplicationAware) {
            ((ApplicationAware) action).setApplication(context.getApplication());
        }
        
   if (action instanceof SessionAware) {
            ((SessionAware) action).setSession(context.getSession());
        }
        
   if (action instanceof RequestAware) {
            ((RequestAware) action).setRequest((Map) context.get("request"));
        }
 */
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {

	//service对象
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;

	//域对象
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
		
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//ModelDriven
	protected T model;
	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class)type.getActualTypeArguments()[0];
		try {
			model = (T)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
		return model;
	}
}
