package com.news.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.News;
import com.spring.service.CommentsServices;
import com.spring.service.NewsService;


/**
 * 修改
 * Title:ManageServlet
 * @author 12782
 *
 */
public class ManageServlet extends HttpServlet {
	
//	private static final long serialVersionUID = 1L;
//	//声明服务接口
//	CommentsServices commentsServices;
//	NewsService newsService;
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String opr = req.getParameter("opr");
		PrintWriter out = resp.getWriter();

		if(opr.equals("update")){
			int tid = Integer.parseInt(req.getParameter("tid"));
			String tname = req.getParameter("tname");
			
			CommentsServices commentsServices = (CommentsServices) context.getBean("commentsServices");
			int result=commentsServices.updateTopicByTid(tid, tname);
			
			if(result>0){
				//添加ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('主题修改成功');" +
	        			"location.href='http://localhost:8080/Test_News/news?id=titleManage';" +
	        			"</script>";
	        	out.println(js);
			}
//			http://localhost:8080/Test_News/titleManage.jsp
			//重新显示该条新闻
	        out.flush();
	        out.close();
			
		}
		else if(opr.equals("delete")){
			int tid = Integer.parseInt(req.getParameter("tid"));
			CommentsServices commentsServices = (CommentsServices) context.getBean("commentsServices");
			int result=commentsServices.deleteTopicByTid(tid);
			if(result>0){
				//添加ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('删除成功');" +
	        			"location.href='http://localhost:8080/Test_News/news?id=titleManage';" +
	        			"</script>";
	        	out.println(js);
			}
	        out.flush();
	        out.close();
		}else if(opr.equals("addNews")){
			//表单提交添加新闻信息
			int ntid = Integer.parseInt(req.getParameter("ntid"));
			String ntitle = req.getParameter("ntitle");
			String nauthor = req.getParameter("nauthor");
			String nsummary = req.getParameter("nsummary");
			String ncontent = req.getParameter("ncontent");
			Date ncreateDate = new Date();
			
			News news = new News();
			news.setNtid(ntid);
			news.setNtitle(ntitle);
			news.setNauthor(nauthor);
			news.setNsummary(nsummary);
			news.setNcreateDate(ncreateDate);
			news.setNcontent(ncontent);
					
			
			NewsService newsService = (NewsService) context.getBean("newsServiceImpl");
			int result = newsService.addNews(news);
			
			if(result>0){
				//添加ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('添加新闻成功');" +
	        			"location.href='http://localhost:8080/Test_News/news?id=addNews';" +
	        			"</script>";
	        	out.println(js);
			}
			
		}
		
	}
}
