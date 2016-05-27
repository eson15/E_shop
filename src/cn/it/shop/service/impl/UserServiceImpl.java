package cn.it.shop.service.impl;

import org.springframework.stereotype.Service;
import cn.it.shop.model.User;
import cn.it.shop.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
