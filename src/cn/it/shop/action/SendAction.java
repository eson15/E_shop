package cn.it.shop.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description: TODO(此Action用来完成WEB-INF中JSP与JSP请求转发功能，此Action不处理任何的逻辑)
 * @author Ni Shengwu
 *
 */
@Controller("sendAction")
public class SendAction extends ActionSupport {
	
	public String execute() {
		return "send";
	}
}
