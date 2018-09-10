package zx.com.filter;

import java.io.IOException;
import java.net.HttpRetryException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import zx.com.bean.User;
import zx.com.dao.Login;

public class OutoLogin implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpServletRequest re=(HttpServletRequest) request;
		Cookie[] coo=re.getCookies();
		String user=null;
		String pass=null;
		if(coo!=null){
			for (Cookie cookie : coo) {
				if(cookie.getName().equals("user")){
					user=URLDecoder.decode(cookie.getValue(),"utf-8");
				}else if(cookie.getName().equals("pass")){
					pass=cookie.getValue();
				}
			}
			System.out.println(user);
			System.out.println(pass);
			User zx=Login.login(user, pass);
			HttpSession se=re.getSession();
			se.setAttribute("user", zx);
		}

		chain.doFilter(re, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
