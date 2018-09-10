package zx.com.service;

import java.sql.SQLException;
import java.util.List;

import zx.com.dao.ProductHeadDao;

public class ProductHeadService {

	public static List<Object> find(String name) {
		// TODO Auto-generated method stub
		 List<Object> zx=null;
		try {
			zx=ProductHeadDao.find(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zx;
	}

}
