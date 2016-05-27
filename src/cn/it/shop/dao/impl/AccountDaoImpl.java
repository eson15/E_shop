package cn.it.shop.dao.impl;

import org.springframework.stereotype.Repository;

import cn.it.shop.dao.AccountDao;
import cn.it.shop.model.Account;
/**
 * @Description TODO（模块自身的业务逻辑）
 * @author Ni Shengwu
 *
 */
@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	/*
	 * 只需实现AccountService接口中新增的方法即可，公共方法已经在BaseServiceImpl中实现了
	 */
	
	//管理登陆功能
}
