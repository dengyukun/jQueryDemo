package org.lanqiao.dao;

import java.util.ArrayList;

import org.lanqiao.entity.UserInfo;


public interface UserDao {
	
	/**
	 * ��ѯȫ���û�
	 * @param userId
	 * @return
	 */
	ArrayList<UserInfo> selectUserList();
	
	/**
	 * ����ʺ��Ƿ����
	 * @param username
	 * @return
	 */
	boolean checkExistsUsername(String username);
	
	/**
	 * ��������Ƿ����
	 * @param email
	 * @return
	 */
	boolean checkExistsEmail(String email);
}
