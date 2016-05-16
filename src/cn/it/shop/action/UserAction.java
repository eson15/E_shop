package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	public String login() {
		//进行登陆的判断
		model = userService.login(model);
		if(model == null) {
			session.put("error", "登陆失败");
			return "login";
		} else {
			//登录成功，先将用户存储到session中
			session.put("user", model);
			return "index";
		}
	}
}
