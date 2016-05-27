package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;
@Service("sorderService")
@SuppressWarnings("unchecked")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave = false; //用来标记有没有重复购物项
		//拿到当前的购物项
		Sorder sorder = productToSorder(product);
		//判断当前购物项是否重复，如果重复，则添加数量即可
		for(Sorder old : forder.getSorders()) {
			if(old.getProduct().getId().equals(sorder.getProduct().getId())) {
				//购物项有重复，添加数量即可
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		//当前购物项在购物车中不存在，新添加即可
		if(!isHave) {
			//在向购物中添加购物项之前，先建立购物项与购物车的关联，但是此时forder.id为null，
			//但是在入库的时候是先入库购物车，再入库购物项，那时候就有主键了
			sorder.setForder(forder);
			forder.getSorders().add(sorder);
		}
		
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder updateSorder(Sorder sorder, Forder forder) {
		for(Sorder temp : forder.getSorders()) {
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())) {
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}
	
	@Override
	public List<Object> querySale(int number) {
		return sorderDao.querySale(number);
	}
}
