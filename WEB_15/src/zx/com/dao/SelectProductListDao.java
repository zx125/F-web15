package zx.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import zx.com.bean.Product;
import zx.com.util.c3p0Util;
import zx.com.vo.Select1;

public class SelectProductListDao {

	public static List<Product> findProduct(Select1 bean) throws SQLException {
		// TODO Auto-generated method stub
		List zx=new ArrayList<String>();
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from product where 1=1 ";
		if(!bean.getPname().trim().equals("")){
			sql+=" and pname like ? ";
			zx.add("%"+bean.getPname().trim()+"%");
		}
		if(!bean.getIs_hot().trim().equals("")){
			sql+=" and is_hot=? ";
			zx.add(bean.getIs_hot());
		}
		if(!bean.getCid().trim().equals("")){
			sql+=" and cid=? ";
			zx.add(bean.getCid());
		}
		
		return runner.query(sql, new BeanListHandler<Product>(Product.class),zx.toArray());
	}

}
