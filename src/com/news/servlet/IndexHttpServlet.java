package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.news.pojo.News;
import com.news.pojo.Topic;
import com.spring.service.NewsService;
import com.spring.service.TopicServices;

/**
 * ��ȡ��ҳ����  servlet
 * @author yin
 *
 */
public class IndexHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//��������ӿ�
//	TopicServices topicServices;
//	NewsService newsService;
	ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * ����ͻ�������
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsService newsService = (NewsService) context.getBean("newsServiceImpl");
		TopicServices topicServices = (TopicServices) context.getBean("topicServices");
		
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		//��ȡ�ܵ���������
		
		
		if(id.equals("getIndexdata"))//��ȡ��ҳ����
		{
			
			int data6 = newsService.getAllNewsCount();
			int Pno=0;//�ڼ�ҳ
			String pageno=req.getParameter("pageno");
			if(pageno==null||"".equals(pageno)){
				Pno=0;
			}else{
				Pno=Integer.parseInt(pageno);
				if(Pno<0)
					Pno=0;
				if(Pno>=(data6%20==0?data6/20:data6/20+1))
					Pno=(data6%20==0?data6/20:data6/20+1)-1;
			}
			
			//�������ŷ���ӿڣ���ȡ����  ��Ӧ
			List<Topic> data4 = topicServices.getAllTopic();
			//��������
			List<News> data1 = newsService.getNewsByTid(1, 0, 6);
			//��������
			List<News> data2 = newsService.getNewsByTid(2, 0, 6);
			//��������
			List<News> data3 = newsService.getNewsByTid(5, 0, 6);
			//��ȡȫ������
			List<News> data5 = newsService.getAllNews(Pno*20,20);
			
			
			req.setAttribute("news1", data1);
			req.setAttribute("news2", data2);
			req.setAttribute("news3", data3);
			req.setAttribute("news4", data4);
			req.setAttribute("news5", data5);
			//��ҳ
			req.setAttribute("news6", Pno);//��ǰҳ
			req.setAttribute("news7", data6%20==0?data6/20:data6/20+1);//��ҳ��
			//ת��
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		 //index?id=listTitle&tid=${topic.tid}
		else if(id.equals("listTitle")){
			int tid = 1;
			try{
				tid = Integer.parseInt(req.getParameter("tid"));
			}catch (Exception e) {
				tid = 1;
			}
			
			int data6 = newsService.getAllNewsCount(tid);
			int Pno=0;//�ڼ�ҳ
			String pageno=req.getParameter("pageno");
			if(pageno==null||"".equals(pageno)){
				Pno=0;
		}else{
				Pno=Integer.parseInt(pageno);
				if(Pno<0)
					Pno=0;
				if(Pno>=(data6%20==0?data6/20:data6/20+1))
					Pno=(data6%20==0?data6/20:data6/20+1)-1;
		}
			
			//�������ŷ���ӿڣ���ȡ����  ��Ӧ
			List<Topic> data4 = topicServices.getAllTopic();
			//��������
			List<News> data1 = newsService.getNewsByTid(1, 0, 6);
			//��������
			List<News> data2 = newsService.getNewsByTid(2, 0, 6);
			//��������
			List<News> data3 = newsService.getNewsByTid(5, 0, 6);
			List<News> data5 = newsService.getNewsByTid(tid,0,20);
			
			req.setAttribute("tid", tid);
			req.setAttribute("news1", data1);
			req.setAttribute("news2", data2);
			req.setAttribute("news3", data3);
			req.setAttribute("news4", data4);
			req.setAttribute("news5", data5);
			//��ҳ
			req.setAttribute("news6", Pno);//��ǰҳ
			req.setAttribute("news7", (data6%20==0?data6/20:data6/20)+1);//��ҳ��
			//ת��
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
