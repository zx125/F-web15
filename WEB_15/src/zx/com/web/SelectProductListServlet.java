package zx.com.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import zx.com.bean.Category;
import zx.com.bean.Product;
import zx.com.service.FindAllCategoryService;
import zx.com.service.SelectProductListService;
import zx.com.vo.Select1;

/**
 * Servlet implementation class SelectProductListServlet
 */
@WebServlet("/SelectProductListServlet")
public class SelectProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Select1 bean=new Select1();
		try {
			BeanUtils.populate(bean, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<Product> ProductList=SelectProductListService.findProduct(bean);
		request.setAttribute("ProductList", ProductList);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("ProductListServlet1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
