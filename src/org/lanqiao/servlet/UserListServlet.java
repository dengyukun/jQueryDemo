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
		
		//Access-Control-Allow-Origin，HTTP响应头，指定服务器端允许进行跨域资源访问的来源域
		//可以用通配符*表示允许任何域的JavaScript访问资源
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//从数据库查询用户列表
		ArrayList<UserInfo> userArray=dao.selectUserList();
		
		//构造成json字符串，然后响应给客户端
		/*
		 * UserInfo对象1：属性1，属性2，属性3。。。。
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
