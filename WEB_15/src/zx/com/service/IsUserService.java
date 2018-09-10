package zx.com.service;

import java.sql.SQLException;

import zx.com.dao.IsUserDao;

public class IsUserService {

	public static boolean iszx(String user) {
		// TODO Auto-generated method stub
		try {
			long zx=IsUserDao.find(user);
			if(zx>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
