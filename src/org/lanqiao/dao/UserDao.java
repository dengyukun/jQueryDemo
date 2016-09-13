package org.lanqiao.dao;

import java.util.ArrayList;

import org.lanqiao.entity.UserInfo;


public interface UserDao {
	
	/**
	 * 查询全部用户
	 * @param userId
	 * @return
	 */
	ArrayList<UserInfo> selectUserList();
	
	/**
	 * 检测帐号是否存在
	 * @param username
	 * @return
	 */
	boolean checkExistsUsername(String username);
	
	/**
	 * 检测邮箱是否存在
	 * @param email
	 * @return
	 */
	boolean checkExistsEmail(String email);
}
