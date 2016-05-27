package cn.it.shop.dao.impl;


import java.math.BigDecimal;

import org.springframework.stereotype.Repository;


import cn.it.shop.dao.ForderDao;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;


@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements ForderDao {

	@Override
	public void updateStatusById(int id, int sid) {
		String hql = "update Forder f set f.status.id=:sid where f.id=:id";
		getSession().createQuery(hql)
			.setInteger("sid", sid)
			.setInteger("id", id)
			.executeUpdate();
	}
	
}
