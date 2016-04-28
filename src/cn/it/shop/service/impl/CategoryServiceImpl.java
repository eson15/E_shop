package cn.it.shop.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.utils.HibernateSessionFactory;
/**
 * @Description TODO（目前Service和DAO整合在一起，没有抽取）
 * @author Ni Shengwu
 *
 */
public class CategoryServiceImpl implements CategoryService {

	@Override //没有整合的情况
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
	/*Spring和Hibernate整个后*/
	private SessionFactory sessionFactory;
	
	//Spring会注进来
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		//从当前线程获取session，如果没有则创建一个新的session
		return sessionFactory.getCurrentSession();
	}
	
	@Override //整合后的情况
	public void update(Category category) {
		getSession().update(category);	
	}

}
