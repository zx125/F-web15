 package zx.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.junit.runner.Runner;

import zx.com.bean.Category;
import zx.com.bean.Product;
import zx.com.util.c3p0Util;

public class ProductList {
	@Test
	public static List<Product>  QuProduct(){
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from product";
		List<Product> productlist =null;
		try {
			productlist=runner.query(sql,new BeanListHandler<Product>(Product.class));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productlist;
	}
	public static Product  QuProductOne(String id){
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from product where pid=?";
		Object[] zx={id};
		Product product =null;
		try {
			product=runner.query(sql, zx,new BeanHandler<Product>(Product.class));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	public static List<Category> AddProductListUIDao() throws SQLException{
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="select * from category";
		List<Category> zx=null;
		zx=runner.query(sql, new BeanListHandler<Category>((Category.class)));
		return zx;
	}
	public static void AddProductDao(Product product) throws SQLException{
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="insert into product values (?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid());
	}
	public static void delProduct(String pid) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(c3p0Util.getDataSource());
		String sql="delete from product where pid=? ";
		queryRunner.update(sql, pid);
	}
	public static void updateProduct(Product product) throws SQLException{
		QueryRunner runner=new QueryRunner(c3p0Util.getDataSource());
		String sql="update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		runner.update(sql,product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
	}
}
