package cn.it.shop.service.impl;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.model.User;
import cn.it.shop.service.SorderService;
import cn.it.shop.service.UserService;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Override
	public User login(User user) {
		String hql = "from User u where u.login=:login and u.pass=:pass";
		return (User) getSession().createQuery(hql) //
			.setString("login", user.getLogin()) //
			.setString("pass", user.getPass()) //
			.uniqueResult();
	}

}
