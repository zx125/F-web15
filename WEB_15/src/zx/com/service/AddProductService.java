package zx.com.service;

import java.sql.SQLException;

import zx.com.bean.Product;
import zx.com.dao.ProductList;

public class AddProductService {
	public static void add(Product product){
		try {
			ProductList.AddProductDao(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
