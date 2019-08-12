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
 * �޸�
 * Title:ManageServlet
 * @author 12782
 *
 */
public class ManageServlet extends HttpServlet {
	
//	private static final long serialVersionUID = 1L;
//	//��������ӿ�
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
				//���ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('�����޸ĳɹ�');" +
	        			"location.href='http://localhost:8080/Test_News/news?id=titleManage';" +
	        			"</script>";
	        	out.println(js);
			}
//			http://localhost:8080/Test_News/titleManage.jsp
			//������ʾ��������
	        out.flush();
	        out.close();
			
		}
		else if(opr.equals("delete")){
			int tid = Integer.parseInt(req.getParameter("tid"));
			CommentsServices commentsServices = (CommentsServices) context.getBean("commentsServices");
			int result=commentsServices.deleteTopicByTid(tid);
			if(result>0){
				//���ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('ɾ���ɹ�');" +
	        			"location.href='http://localhost:8080/Test_News/news?id=titleManage';" +
	        			"</script>";
	        	out.println(js);
			}
	        out.flush();
	        out.close();
		}else if(opr.equals("addNews")){
			//���ύ���������Ϣ
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
				//���ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('������ųɹ�');" +
	        			"location.href='http://localhost:8080/Test_News/news?id=addNews';" +
	        			"</script>";
	        	out.println(js);
			}
			
		}
		
	}
}
