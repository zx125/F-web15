package zx.com.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class BianMa implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		final HttpServletRequest req=(HttpServletRequest) request;
//		HttpServletRequest zx= (HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),
//				req.getClass().getInterfaces(),
//				new InvocationHandler() {
//					
//					@Override
//					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						// TODO Auto-generated method stub
//						String invoke =(String) method.invoke(req, args);
//						invoke=new String(invoke.getBytes("iso8859-1"),"utf-8");
//						return invoke;
//					}
//				});
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
