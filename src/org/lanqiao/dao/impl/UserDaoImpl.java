package org.lanqiao.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.UserInfo;
import org.lanqiao.util.DBUtil;

public class UserDaoImpl implements UserDao {
	public boolean checkExistsUsername(String username) {
		boolean result=false;
		
		DBUtil db = new DBUtil();
		db.openConnection();
		
		try {
			String sql="SELECT * FROM tb_user WHERE user_name=?";
			Object params[]={username};
			ResultSet rs=db.executeQuery(sql, params);
			if (rs.next()) {
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.realeaseSource();
		return result;
	}

	public boolean checkExistsEmail(String email) {
		boolean result=false;
		
		DBUtil db = new DBUtil();
		db.openConnection();
		
		try {
			String sql="SELECT * FROM tb_user WHERE user_email=?";
			Object params[]={email};
			ResultSet rs=db.executeQuery(sql, params);
			if (rs.next()) {
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.realeaseSource();
		return result;
	}

	@Override
	public ArrayList<UserInfo> selectUserList() {
		ArrayList<UserInfo> userArray = new ArrayList<UserInfo>();

		DBUtil db = new DBUtil();
		db.openConnection();

		ResultSet rs = null;
		try {
			String sql="SELECT * FROM tb_user";
			rs=db.executeQuery(sql, null);
			while (rs.next()) {
				UserInfo userInfo=new UserInfo();
				userInfo.setUser_id(rs.getInt("user_id"));
				userInfo.setUser_pwd(rs.getString("user_pwd"));
				userInfo.setUser_name(rs.getString("user_name"));
				userInfo.setUser_email(rs.getString("user_email"));
				userInfo.setUser_sex(rs.getString("user_sex").charAt(0));
				userInfo.setUser_phone(rs.getString("user_phone"));
				userInfo.setUser_address(rs.getString("user_address"));
				userInfo.setQuestion_id(rs.getInt("question_id"));
				userInfo.setQuestion_answer(rs.getString("question_answer"));
				userArray.add(userInfo);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				db.realeaseSource();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userArray;
	}

}
