package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * DB工具类（具有单例模式）
 * 
 * @author Yock
 * 
 */
public class DBUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver"; // 驱动
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/eshop"; // url
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private Connection conn = null;
	private PreparedStatement preStmt = null;
	private Statement stmt = null;

	// 打开数据库
	public void openConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL + "?user=" + USERNAME
					+ "&password=" + PASSWORD
					+ "&useUnicode=true&characterEncoding=utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 查询语句
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//查询语句（防止sql注入）
	public ResultSet executeQuery(String sql,Object[] params) {
		ResultSet rs = null;
		try {
			preStmt=conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					preStmt.setObject(i+1, params[i]);
				}
			}
	    	rs=preStmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// 执行一条DML语句（增删改）
	public int executeUpdate(String sql) {
		int result = -1;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int executeUpdate(String sql,Object []params) {
		int result = -1;
		try {
			preStmt=conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					preStmt.setObject(i+1, params[i]);
				}
			}
			result=preStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//执行多条DML语句（增删改），要考虑清除事务处理
	public boolean executeUpdate(String sqls[],Object [][]params){
		boolean result=true;
		try {
			//取消自动提交事务
			conn.setAutoCommit(false);
			
			for (int i = 0; i < sqls.length; i++) {
				preStmt=conn.prepareStatement(sqls[i]);
				
				if(params[i]!=null){
					for(int j=0;j<params[i].length;j++){
						if (params[i][j]!=null) {
							preStmt.setObject(j+1, params[i][j]);
						}
					}
					preStmt.executeUpdate();
				}
			}
			//提交事务
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=false;
			
			try {
				//回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return result;
		
	}
	public boolean executeUpdate2(Object sqls[]){
		boolean result=true;
		try {
			//取消自动提交事务
			conn.setAutoCommit(false);
			
			for (int i = 0; i < sqls.length; i++) {
				preStmt=conn.prepareStatement((String)sqls[i]);
				preStmt.executeUpdate();
			}
			//提交事务
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=false;
			
			try {
				//回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return result;
		
	}
	

	// 释放资源（conn、rs、preStmt）
	public void realeaseSource() {
		try {
			if (stmt != null){
				stmt.close();
				stmt=null;
			}
			if (preStmt != null){
				preStmt.close();
				preStmt=null;
			}
			if (conn != null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
