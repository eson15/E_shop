package cn.it.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 判断当前session是否有用户信息
		if(req.getSession().getAttribute("user") == null) {
			//保存当前客户想要去的url地址
			String goURL = req.getServletPath();//获得用户想要去的地址
			String param = req.getQueryString(); //获得地址中携带的参数
			if(param != null) {
				goURL = goURL + "?" + param; //重新拼好请求地址+参数
			}
			//把当前客户想要访问的地址，存储到session中
			req.getSession().setAttribute("goURL", goURL);
			
			//非法请求，跳转到登陆页面
			req.getSession().setAttribute("error", "非法请求，请登录！");
			res.sendRedirect(req.getContextPath() + "/ulogin.jsp");
		} else {
			//如果有下一个过滤器则跳转，否则直接到目标页面
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
