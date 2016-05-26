package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

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
			session.put("forder", new Forder(new ArrayList<Sorder>()));
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
	
	//根据商品编号更新商品数量
	public String updateSorder() {
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.updateSorder(model, forder);
		//计算新的总价格
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder", forder);
		//以流的形式返回新的总价格
		inputStream = new ByteArrayInputStream(forder.getTotal().toString().getBytes());
		return "stream";
	}
	
	//
	public String querySale() {
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		
		//但这里jsonList是个List<Object>对象，不是BaseAction中的List<T>对象，所以不能使用BaseAction中的List<T>对象来接收
		//所以要在这个Action中新建一个List<Object>并实现set方法，但是有点麻烦
		//这里介绍个更加简便的方法，之前都是先把返回的jsonList经过strus.xml文件配置给root，然后才能将jsonList转成json格式
		//其实我们不用在struts.xml中配root，struts2如果找不到root，就会从值栈的栈顶拿出来数据来转json
		//所以我们只要将现在拿到的jsonList扔到值栈的栈顶，然后在配置文件中写好result就可以了
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
