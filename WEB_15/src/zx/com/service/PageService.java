package zx.com.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import zx.com.bean.Product;
import zx.com.dao.PageDao;
import zx.com.vo.pageconfig;

public class PageService {
	public static  pageconfig<Product> pagedata(pageconfig<Product> productlist) {
		// TODO Auto-generated method stub
		int zx = 0;
		int zy=0;
		try {
			zx=(int) PageDao.getallpagetime();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productlist.setAlldata(zx);
		int zc=(int) Math.ceil(1.0*zx/productlist.getThisdata());
		productlist.setAllpage(zc);
		try {
			List<Product> list=PageDao.getallpagedata(productlist.getThispage(),productlist.getThisdata());
			System.out.println(productlist.getThispage());
			System.out.println(productlist.getThisdata());
			productlist.setList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productlist;
	}

}
