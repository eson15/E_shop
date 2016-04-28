package cn.it.shop.service.impl;

import org.hibernate.Session;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.utils.HibernateSessionFactory;
/**
 * @Description TODO（目前Service和DAO整合在一起，没有抽取）
 * @author Ni Shengwu
 *
 */
public class CategoryServiceImpl implements CategoryService {

	@Override
	public void save(Category category) {
		//通过工具类获取session
		Session session = HibernateSessionFactory.getSession();
		try {
			//手动事务
			session.getTransaction().begin();
			//执行业务逻辑
			session.save(category);
			//手动提交
			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
	}

}
