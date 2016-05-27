package cn.it.shop.dao;

import java.math.BigDecimal;

import cn.it.shop.model.Forder;

public interface ForderDao extends BaseDao<Forder> {
	//根据订单编号，更新订单状态
	public void updateStatusById(int id, int sid);
}
