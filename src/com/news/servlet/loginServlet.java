package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.Users;
import com.news.services.UserServiceImpl;
import com.spring.service.UserServices;



public class loginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	UserService userService;
	ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//用户登录
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
//		userService = new UserServiceImpl();
		
		if(id.equals("login")){
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			session.setAttribute("uname", username);
			
			UserServices userService = (UserServices) context.getBean("userServices");
			Users user = userService.getUser(username,password);
			String type = user.getType();
			session.setAttribute("isAdmin", type);
			if(user != null){

//				将用户信息显示在成功页面
				
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
	
	}else if(id.equals("reg")){
		String username = req.getParameter("username");
		String userpassword = req.getParameter("password");
		
		UserServices userService = (UserServices) context.getBean("userServices");
		Users u = new Users();
		u.setUname(username);
		u.setUpwd(userpassword);
		int result = userService.regUser(u);
		if(result>0){
			String js = "<script type='text/javascript'>" +
        			"alert('注册成功');" +
        			"location.href='user?id=login'"+
        			"</script>";
        	out.println(js);
		}
		else
		{
			String js = "<script type='text/javascript'>" +
        			"alert('注册失败');" +
        			"location.href='user?id=reg'" +
        			"</script>";
        	out.println(js);
		}
	}
}
}
