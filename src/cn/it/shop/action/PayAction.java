package cn.it.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



import cn.it.shop.model.BackData;
import cn.it.shop.model.Forder;
import cn.it.shop.model.SendData;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;
/**
 * Struts处理流程：
 * 1. 获取请求后，先创建Action代理，在创建代理的时候顺便创建了Action，
 * 2. 执行18个拦截器，拦截器执行成功后再调用Action的方法
 * 3. Action的方法执行完毕后，再调用18个拦截器
 * 所以先创建Action-->servletConfig(拿到parameters)-->modelDriven
 * @author Ni Shengwu
 *
 */
@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware {
	
	private Map<String, String[]> parameters;
	
	@Override
	public Object getModel() {
		if(parameters.get("pd_FrpId") != null) {
			model = new SendData();
		} else {
			model = new BackData();
		}
		return model;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
		
	}
	
	public String goBank() {
		SendData sendData = (SendData)model;
		//1. 补全参数:P2 p3 pd Pa需要从session中获取
		Forder forder = (Forder) session.get("oldForder");
		User user = (User) session.get("user");
		sendData.setP2_Order(forder.getId().toString()); //商户订单号
		sendData.setP3_Amt(forder.getTotal().toString()); //支付金额
		sendData.setPa_MP(user.getEmail() + "," + user.getPhone()); //商户扩展信息
		//2. 对参数进行追加		
		//3. 加密获取签名		
		//4. 存储到request域中
		payService.saveDataToRequest(request, sendData); //完成2,3,4
		//5. 跳转到支付页面
		
		return "pay";
	}

	public String backBank() {
		BackData backData = (BackData)model;
		System.out.println(model);
		boolean isOK = payService.checkBackData(backData);
		if(isOK) {
			//1. 更新订单状态,参数是自己根据数据库中的情况传进去的，用来测试
			forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()), 2);
			//2. 根据user邮箱地址，发送邮件
			String emailAddress = backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(emailAddress, backData.getR6_Order());
			//3. 发送手机短信
			String phoneNum = backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(phoneNum, backData.getR6_Order());
			System.out.println("----success!!----");
			return "index";
		} else {
			System.out.println("----false!!!----");
			return "error";
		}
	}

}
