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
			//根据session中goURL是否有值而决定页面的跳转
			if(session.get("goURL") == null) {
				return "index"; //跳到首页
			} else {
				return "goURL";
			}
		}
	}
}
