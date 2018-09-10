package zx.com.service;

import java.util.List;

import org.junit.Test;

import zx.com.bean.Product;
import zx.com.dao.ProductList;

public class ProductService {
	public static List<Product> findall(){
		List<Product> quProduct = ProductList.QuProduct();
		return quProduct;
	}
	public static  Product  query(String id){
		Product ProductOne = ProductList.QuProductOne(id);
		System.out.println(ProductOne);
		return ProductOne;
	}

}
