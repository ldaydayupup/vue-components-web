package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * ��¼ע�� 
 * @author yin
 *
 */
public class UserHttpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =  request.getParameter("id");
		//�ж��û��ǵ�¼����ע��
		if(id.equals("login")){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(id.equals("reg")){
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
