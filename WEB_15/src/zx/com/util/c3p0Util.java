package zx.com.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Util {
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("oracle");
	public static DataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
