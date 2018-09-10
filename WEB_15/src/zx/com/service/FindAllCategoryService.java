package zx.com.service;

import java.sql.SQLException;
import java.util.List;

import zx.com.bean.Category;
import zx.com.dao.ProductList;

public class FindAllCategoryService {
	public static List<Category> findall(){
		List<Category> zx=null;
		try {
			zx=ProductList.AddProductListUIDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zx;
	}
}
