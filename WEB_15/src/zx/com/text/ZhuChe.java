package zx.com.text;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import zx.com.bean.User;
import zx.com.util.c3p0Util;



public class ZhuChe {
	@Test
	public void add(){
		QueryRunner qr=new QueryRunner(c3p0Util.getDataSource());
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
		Object[] zx={2,"zx","zx125","jet","1121437890@icloud.com","12345","10 5","男",2,"asd"};
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

	public void Quarall(){
		QueryRunner qr=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from answers";
		try {
			List<User> lzx = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : lzx) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
