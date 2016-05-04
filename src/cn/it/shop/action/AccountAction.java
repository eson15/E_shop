package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Account;

@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	
	public String query() {	
		System.out.println(model);
		return "index";
	}

}
