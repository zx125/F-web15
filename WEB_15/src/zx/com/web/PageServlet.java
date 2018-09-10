package zx.com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zx.com.bean.Product;
import zx.com.service.PageService;
import zx.com.vo.pageconfig;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pageconfig<Product> productlist=new pageconfig<Product>();
		productlist.setThisdata(12);
		if(request.getParameter("thispage")==null)
		{
			productlist.setThispage(1);
		}else{
			productlist.setThispage(Integer.valueOf(request.getParameter("thispage")));
		}
		pageconfig<Product> pagedata = PageService.pagedata(productlist);
		
		System.out.println(pagedata);
		request.setAttribute("pagedata", pagedata);
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
