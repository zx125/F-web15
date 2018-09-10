package zx.com.service;

import java.sql.SQLException;

import zx.com.bean.Product;
import zx.com.dao.ProductList;

public class UpdateProductService {
	public static void updateprodate(Product product){
		try {
			ProductList.updateProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
