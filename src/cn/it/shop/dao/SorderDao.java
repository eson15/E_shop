package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
	//查询热点商品的销售量
	public List<Object> querySale(int number);
}
