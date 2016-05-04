package cn.it.shop.action;

import cn.it.shop.model.Account;

public class AccountAction extends BaseAction<Account> {
	
	public String query() {	
		System.out.println(model);
		return "index";
	}

}
