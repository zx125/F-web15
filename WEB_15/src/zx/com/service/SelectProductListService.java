package zx.com.service;

import java.sql.SQLException;
import java.util.List;

import zx.com.bean.Product;
import zx.com.dao.SelectProductListDao;
import zx.com.vo.Select1;

public class SelectProductListService {

	public static List<Product> findProduct(Select1 bean) {
		// TODO Auto-generated method stub
		List<Product> zx=null;
		try {
			 zx= SelectProductListDao.findProduct(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zx;
	}

}
