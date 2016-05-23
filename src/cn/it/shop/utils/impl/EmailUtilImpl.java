package cn.it.shop.utils.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import cn.it.shop.utils.EmailUtil;

/**
 * @Description: TODO(用来完成邮件的发送)
 * @author Ni Shengwu
 *
 */
@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {
	
	@Override
	public void sendEmail(String emailAddress, String id) {
		// 1. 登陆邮件客户端(创建会话session)
		Properties prop = new Properties();
		Session session = null;
		Message message = null;
		Transport transport = null;
		try {
			prop.setProperty("mail.transport.protocol", "smtp");
			// 创建了session会话
			session = Session.getDefaultInstance(prop);
			// 设置debug模式来调试发送信息
			session.setDebug(true);
			// 创建一封邮件对象
			message = new MimeMessage(session);
			// 写信
				message.setSubject("易购商城邮件");
			// 正文内容
			message.setContent("顾客您好，欢迎您光顾网上商城，订单" + id + "已支付成功！", "text/html;charset=utf-8");
			// 附件人地址
			message.setFrom(new InternetAddress("soft03_test@sina.com"));			
			transport = session.getTransport();
			// 链接邮件服务器的认证信息
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			
			// 设置收件人地址，并发送邮件
			transport.sendMessage(message, new InternetAddress[] { new InternetAddress(emailAddress) });
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {			
			try {
				transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
/*
	public static void main(String[] args) throws Exception {
		//1. 登陆邮件客户端(创建会话session)
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");	
		//创建了session会话
		Session session = Session.getDefaultInstance(prop);
		//设置debug模式来调试发送信息
		session.setDebug(true);
		//创建一封邮件对象
		Message message = new MimeMessage(session);
		//写信
		message.setSubject("欢迎访问我的CSDN博客主页！");
		//正文内容
		message.setContent("如果你去访问我的CSDN博客主页：http://blog.csdn.net/eson_15"
				+ "，我就给你个么么哒", "text/html;charset=utf-8");
		//附件人地址
		message.setFrom(new InternetAddress("nishengwus@163.com"));
		Transport transport = session.getTransport();
		//链接邮件服务器的认证信息
		transport.connect("smtp.163.com", "nishengwus", "nishengwu%&");
		// 设置收件人地址，并发送邮件
		transport.sendMessage(message, new InternetAddress[]{new InternetAddress("1320873719@qq.com")});
		transport.close();

	}*/
}
