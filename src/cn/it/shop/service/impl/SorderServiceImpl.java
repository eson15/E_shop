package cn.it.shop.service.impl;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;
@Service("sorderService")
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
}
