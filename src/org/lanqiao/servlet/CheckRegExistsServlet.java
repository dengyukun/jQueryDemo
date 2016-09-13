package org.lanqiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;


@WebServlet("/checkRegExists")
public class CheckRegExistsServlet extends HttpServlet {
	
	private UserDao biz=new UserDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		if ("checkUsername".equals(method)) {
			checkUsername(request, response);
		}
		if ("checkEmail".equals(method)) {
			checkEmail(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void checkUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String username=request.getParameter("username");
		System.out.println("请求过来的："+username);
		boolean result=biz.checkExistsUsername(username);
		if (result) {
			//用户名存在，给客户端响应一个"yes"
			response.getWriter().print("yes");
		}else{
			//用户名不存在，则给客户端响应一个"no"
			response.getWriter().print("no");
		}
	}
	private void checkEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String email=request.getParameter("email");
		boolean result=biz.checkExistsEmail(email);
		if (result) {
			response.getWriter().print("yes");
		}else{
			response.getWriter().print("no");
		}
	}

}
