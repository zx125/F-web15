package zx.com.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import zx.com.bean.User;
import zx.com.util.c3p0Util;

public class ZhuChe {
	@Test
	public static void add(User user){
		QueryRunner qr=new QueryRunner(c3p0Util.getDataSource());
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
		Object[] zx={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),null,user.getBirthday(),user.getSex(),null,null};
		try {
			int rows=qr.update(sql, zx);
			if(rows>0){
				System.out.println("添加成功！");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
