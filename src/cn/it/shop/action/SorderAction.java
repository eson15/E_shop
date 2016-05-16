package cn.it.shop.action;

import java.util.HashSet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	public String addSorder() {
		
		//1. 根据product.id获取相应的商品数据
		Product product = productService.get(model.getProduct().getId());
		
		//2. 判断当前session是否有购物车，如果没有则创建
		if(session.get("forder") == null) {
			//创建新的购物车，存储到session中
			session.put("forder", new Forder(new HashSet<Sorder>()));
		} 

		//3. 把商品信息转化为sorder,并且添加到购物车中（判断购物项是否重复）
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.addSorder(forder, product);
		
		//4. 计算购物的总价格
		forder.setTotal(forderService.cluTotal(forder));
		//5. 把新的购物车存储到session中
		session.put("forder", forder);
		return "showCart";
	}
}
