package cn.it.shop.service;

import java.math.BigDecimal;

import cn.it.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	//计算购物总价格
	public BigDecimal cluTotal(Forder forder);
	//根据订单编号，更新订单状态
	public void updateStatusById(int id, int sid);
}
