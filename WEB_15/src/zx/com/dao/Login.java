package zx.com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import zx.com.bean.User;
import zx.com.util.c3p0Util;

public class Login{
	public static User login(String username,String password){
		QueryRunner qr=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from user where username=? and password=?";
		Object[] zx={username,password};
		User user=null;
		try {
			user=qr.query(sql, zx, new BeanHandler<User>(User.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
