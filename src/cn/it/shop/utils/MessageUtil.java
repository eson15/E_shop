package cn.it.shop.utils;

public interface MessageUtil {

	public abstract void sendMessage(String phoneNum, String id);
	/*	
		public static void main(String[] args) throws Exception {
			//1. 打开浏览器
			HttpClient client = new HttpClient();
			//2. 创建请求的方式：get/post
			PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
			//3. 设置请求的参数信息
			post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			post.setParameter("Uid", "eson_15");
			post.setParameter("Key", "0537729d0b59a7e7358b");
			post.setParameter("smsMob", "15216771570");
			post.setParameter("smsText", "测试一下！");
			//4. 提交请求并返回状态码
			int code = client.executeMethod(post);
			System.out.println("http返回的状态码：" + code);
			//5. 获取服务器端返回的数据信息
			String result = post.getResponseBodyAsString();
			System.out.println("短信发送结果为：" + result);
				
		}*/

}