package zx.com.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zx.com.bean.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String yz=request.getParameter("yanzhen");
		String oi=request.getParameter("outologin");
		if(yz.equals((String)session.getAttribute("checkcode_session"))){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user=zx.com.dao.Login.login(username, password);
			if(user!=null){
				if(oi!=null){
					String lala=URLEncoder.encode(user.getName(), "utf-8");
					Cookie zx1=new Cookie("user",lala);
					Cookie zx2=new Cookie("pass",user.getPassword());
					zx1.setMaxAge(60*60);
					zx2.setMaxAge(60*60);
					zx1.setPath(request.getContextPath());
					zx2.setPath(request.getContextPath());
					response.addCookie(zx1);
					response.addCookie(zx2);
				}
				session.setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}
			else{
				request.setAttribute("loginInfo","账号密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("loginInfo","验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
