package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.Comments;
import com.news.pojo.News;
import com.news.pojo.Topic;
import com.spring.service.CommentsServices;
import com.spring.service.NewsService;
import com.spring.service.TopicServices;

/**
 * ����ģ���servlet
 * ������ӡ�ɾ�����޸�
 * @author yin
 *
 */
public class NewsServlet extends HttpServlet{
	
//	private static final long serialVersionUID = 1L;
//	//��������ӿ�
//	TopicServices topicServices;
//	NewsService newsService;
//	CommentsServices commentsServices;
	ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	//��ȡ����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		NewsService newsService = (NewsService) context.getBean("newsServiceImpl");
		CommentsServices commentsServices = (CommentsServices) context.getBean("commentsServices");
		TopicServices topicServices = (TopicServices) context.getBean("topicServices");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");

		//�ж�id
		if(id.equals("readNew")){
			//�Ķ�����
			int nid = Integer.parseInt(req.getParameter("nid"));
			//��������
			News news = newsService.selectNewsByNid(nid);
			//��������
			List<News> data1 = newsService.getNewsByTid(1, 0, 6);
			//��������
			List<News> data2 = newsService.getNewsByTid(2, 0, 6);
			//��������
			List<News> data3 = newsService.getNewsByTid(5, 0, 6);
			//����
			int cnid = nid;
			List<Comments> data5 = commentsServices.getCommentsByNid(cnid);
			
			req.setAttribute("news1", data1);
			req.setAttribute("news2", data2);
			req.setAttribute("news3", data3);
			req.setAttribute("comments", data5);
			
			if(news !=null){
				
				req.setAttribute("newsBrowse", news);
				//ת������������
				req.getRequestDispatcher("newsBrowse.jsp").forward(req, resp);
			}
		}else if(id.equals("addNews")){
			//�������
			List<Topic> data4 = topicServices.getAllTopic();
			req.setAttribute("news4", data4);
			
			req.getRequestDispatcher("addNews.jsp").forward(req, resp);
			
		}else if(id.equals("newsManage")){
			//�����޸�
			List<News> news = newsService.SelectNews();
			
			if(news !=null){
				req.setAttribute("Nnews", news);
				//ת������������
				req.getRequestDispatcher("newsManage.jsp").forward(req, resp);
			}
		}
		else if(id.equals("addTitle")){
			//�������
			String tname = req.getParameter("tname");
			
			int result=newsService.addTname(tname);
			if(result>0){
				//���ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('�������ɹ�');" +
	        			"location.href='addTitle.jsp';" +
	        			"</script>";
	        	out.println(js);
			}else
			{
				String js = "<script type='text/javascript'>" +
	        			"alert('�������ʧ��');" +
	        			"</script>";
	        	out.println(js);
			}
			//������ʾ��������
	        out.flush();
	        out.close();
			
		}else if(id.equals("titleManage")){
			//�����޸�
			List<Topic> data4 = topicServices.getAllTopic();
			req.setAttribute("news4", data4);
			
			req.getRequestDispatcher("titleManage.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
