package zx.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import zx.com.bean.Product;
import zx.com.util.c3p0Util;

public class PageDao {

	public static long getallpagetime() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select count(*) from Product";
		Long query = (Long) runner.query(sql,new ScalarHandler());
		return query;
	}

	public static List<Product> getallpagedata(int z,int y) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from Product limit ?,?";
		int q=(z-1)*12;
		List<Product> zx=runner.query(sql, new BeanListHandler<Product>(Product.class),q,y);
		return zx;
	}

}
