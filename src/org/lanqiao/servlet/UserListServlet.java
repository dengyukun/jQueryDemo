package org.lanqiao.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.UserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private UserDao dao=new UserDaoImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		
		//Access-Control-Allow-Origin��HTTP��Ӧͷ��ָ����������������п�����Դ���ʵ���Դ��
		//������ͨ���*��ʾ�����κ����JavaScript������Դ
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//�����ݿ��ѯ�û��б�
		ArrayList<UserInfo> userArray=dao.selectUserList();
		
		//�����json�ַ�����Ȼ����Ӧ���ͻ���
		/*
		 * UserInfo����1������1������2������3��������
		 * 
		 */
		JSONObject jo = new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(userArray);
		jo.put("userArray", jsonArray);
		String jsonStr=jo.toString();
		System.out.println(jsonStr);
		
		response.getWriter().print(jsonStr);
		
		
	}

}
