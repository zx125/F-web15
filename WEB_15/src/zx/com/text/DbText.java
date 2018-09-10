package zx.com.text;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import zx.com.dao.ProductList;

public class DbText {

	@Test
	public void text(){
		DbText dbText = new DbText();
		try {
			dbText.login("zx","zx125");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@Test 
	public void text1(){
		DbText dbText = new DbText();
		try {
			dbText.login1("zx","zx125");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login(String name,String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zx125","root","zx125");
		Statement state = con.createStatement();
		String sql="select * from user where "+"uname='"+name+"'and upassword='"+password+"';";
		ResultSet rs = state.executeQuery(sql);
		if(rs.next()){
			System.out.println("登录成功");
			System.out.println(rs);
		}else{
			System.out.println("账号密码错误");
		}
		if(rs!=null){
			rs.close();
		}
		if(state!=null){
			state.close();
		}
		if(con!=null){
 			 con.close();	}
	}
	public void login1(String name,String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zx125","root","zx125");
		String sql="select * from user where uname=? and upassword=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			System.out.println("登录成功");
			System.out.println(rs);
		}else{
			System.out.println("账号密码错误");
		}
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(con!=null){
 			 con.close();	}
	}
	@Test
	public void textlist(){
		ProductList.QuProduct();
	}
	
}
