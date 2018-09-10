package zx.com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import zx.com.util.c3p0Util;

public class IsUserDao {

	public static long find(String user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select count(*) from user where username =?";
		long zx=(Long) runner.query(sql, user, new ScalarHandler());
		return zx;
	}

}
