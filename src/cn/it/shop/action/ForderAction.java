package cn.it.shop.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;

@Controller("forderAction")
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	
	@Override
	public Forder getModel() {
		model = (Forder) session.get("forder");
		return model;
	}

	//实现购物车（订单）与购物项（订单项）级联入库功能
	public String save() {
//		// 把session中的购物项交给当前的model对象
//		Forder forder = (Forder) session.get("forder");
//		//model.setSorders(forder.getSorders());
//		forder.setAddress(model.getAddress());
//		forder.setName(model.getName());
//		forder.setPhone(model.getPhone());
//		forder.setRemark(model.getRemark());
//		forder.setUser((User)session.get("user"));
//		forder.setStatus(new Status(1));
//		forder.setPost(model.getPost());
//		//级联入库(需要在xml或者POJO的注解中配置)，需要sorder关联forder
//		//在SorderServiceImpl类中追加sorder.setForder(forder);
//		forderService.save(forder);
		
		model.setUser((User)session.get("user"));
		model.setStatus(new Status(1));
		forderService.save(model);
		
		//此时购物车已经入库，那么原来session中的购物车就应该清空
		session.put("oldForder", session.get("forder"));//先将原来的购物车信息保存下来，因为后面付款的时候还需要相关信息
		session.put("forder", new Forder());//new一个新的空购物车（相当于清空了购物车），还可以方便用户再买~
		return "bank";
	}
}
