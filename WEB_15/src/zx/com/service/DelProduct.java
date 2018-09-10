package zx.com.service;

import java.sql.SQLException;

import zx.com.dao.ProductList;

public class DelProduct {
	public static void delProduct(String pid){
		try {
			ProductList.delProduct(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
