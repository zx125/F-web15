package zx.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import zx.com.util.c3p0Util;

public class ProductHeadDao {

	public static List<Object> find(String name) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from product where pname like ? limit 0,8";
		System.out.println(name);
		List<Object> query=runner.query(sql, new ColumnListHandler("pname"), "%"+name+"%");
		System.out.println(query);
		return query;
	}

}
