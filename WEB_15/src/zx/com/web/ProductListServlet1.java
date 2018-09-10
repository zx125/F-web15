package zx.com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zx.com.bean.Category;
import zx.com.bean.Product;
import zx.com.service.FindAllCategoryService;
import zx.com.service.ProductService;

/**
 * Servlet implementation class ProductListServlet1
 */
@WebServlet("/ProductListServlet1")
public class ProductListServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> list = ProductService.findall();
		request.setAttribute("ProductList", list);
		List<Category> categorylist=null;
		categorylist=FindAllCategoryService.findall();
		request.setAttribute("categorylist", categorylist);
		request.getRequestDispatcher("admin/product/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
