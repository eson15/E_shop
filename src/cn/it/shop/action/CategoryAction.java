package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends BaseAction<Category> {
	
	public String update() {
		System.out.println("----update----");
		categoryService.update(model);
		return "index";
	}
	
	public String save() {
		System.out.println("----save----");
		System.out.println(model);
		return "index";
	}
	
	public String query() {
		//解决方案一，采用相应的map取代原来的内置对象，这样与jsp没有依赖，但是代码量比较大
//		ActionContext.getContext().put("categoryList", categoryService.query()); //放到request域中
//		ActionContext.getContext().getSession().put("categoryList", categoryService.query()); //放到session域中
//		ActionContext.getContext().getApplication().put("categoryList", categoryService.query()); //放到application域中
		
		//解决方案二，实现相应的接口(RequestAware,SessionAware,ApplicationAware)，让相应的map注入
		request.put("categoryList", categoryService.query()); 
		session.put("categoryList", categoryService.query()); 
		application.put("categoryList", categoryService.query()); 
		return "index";
	}

}
