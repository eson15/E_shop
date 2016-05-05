package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
/**
 * @Description TODO（模块自身的业务逻辑）
 * @author Ni Shengwu
 *
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		String hql = "from Category c left join fetch c.account where c.type like :type";
		return getSession().createQuery(hql)
				.setString("type", "%" + type + "%")
				.setFirstResult((page-1) * size) //从第几个开始显示
				.setMaxResults(size) //显示几个
				.list();
	}
}
