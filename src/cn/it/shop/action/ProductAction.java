package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Product;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String queryJoinCategory() {
		System.out.println("name:" + model.getName());
		System.out.println("page：" + page);
		System.out.println("rows：" + rows);
		
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		
		//根据关键字和分页的参数查询相应的数据
		List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList); //存储为JSON格式
		//根据关键字查询总记录数
		Long total = productService.getCount(model.getName());
//				System.out.println(total);
		pageMap.put("total", total); //存储为JSON格式
		return "jsonMap";
	}
	
	public void save() {
		//fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
		String pic = fileUpload.uploadFile(fileImage);
		
		model.setPic(pic);
		model.setDate(new Date());
		System.out.println(model);
		//商品信息入库
		productService.save(model);
	}
	
	public String deleteByIds() {
		System.out.println(ids);
		productService.deleteByIds(ids);
		//如果删除成功就会往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void update() {
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		System.out.println(model);
		//更新商品
		productService.update(model);
	}
	
	public String get() {
		request.put("product", productService.get(model.getId()));
		return "detail";
	}
}
