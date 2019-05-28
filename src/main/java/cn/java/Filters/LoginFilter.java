package cn.java.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 过滤器
 * 
 * @author Administrator
 *
 */

@Component
//开启注解  扫描路径   --,filterName = "loginFilter"
 @WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

	/**
	 * 初始化
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	
	
	
	
	
	/**
	 * 通过注解方式进入拦截器
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response , FilterChain fc)
			throws IOException, ServletException {
		/*// 响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("被无情的过滤了----------");
		//放行
		fc.doFilter(req,resp);*/
		
		//application 域
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse  resp=(HttpServletResponse)response;
		//获取application 域
		ServletContext application = req.getServletContext();
		Object num = application.getAttribute("num");
		if(num==null) {//第一次访问
			application.setAttribute("num", 1);
		}else {
			int temp=(Integer)num;
			temp++;
			application.setAttribute("num", temp);
		}
		//放行
		fc.doFilter(req, resp);
		
	}
	
	
	
	/**
	 * 销毁
	 */
	@Override
	public void destroy() {

	}
}
