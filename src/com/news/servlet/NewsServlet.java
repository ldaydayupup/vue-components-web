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
 * 新闻模块的servlet
 * 读、添加、删除、修改
 * @author yin
 *
 */
public class NewsServlet extends HttpServlet{
	
//	private static final long serialVersionUID = 1L;
//	//声明服务接口
//	TopicServices topicServices;
//	NewsService newsService;
//	CommentsServices commentsServices;
	ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	//获取新闻
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

		//判断id
		if(id.equals("readNew")){
			//阅读新闻
			int nid = Integer.parseInt(req.getParameter("nid"));
			//新闻详情
			News news = newsService.selectNewsByNid(nid);
			//国内新闻
			List<News> data1 = newsService.getNewsByTid(1, 0, 6);
			//国际新闻
			List<News> data2 = newsService.getNewsByTid(2, 0, 6);
			//娱乐新闻
			List<News> data3 = newsService.getNewsByTid(5, 0, 6);
			//评论
			int cnid = nid;
			List<Comments> data5 = commentsServices.getCommentsByNid(cnid);
			
			req.setAttribute("news1", data1);
			req.setAttribute("news2", data2);
			req.setAttribute("news3", data3);
			req.setAttribute("comments", data5);
			
			if(news !=null){
				
				req.setAttribute("newsBrowse", news);
				//转发到新闻详情
				req.getRequestDispatcher("newsBrowse.jsp").forward(req, resp);
			}
		}else if(id.equals("addNews")){
			//添加新闻
			List<Topic> data4 = topicServices.getAllTopic();
			req.setAttribute("news4", data4);
			
			req.getRequestDispatcher("addNews.jsp").forward(req, resp);
			
		}else if(id.equals("newsManage")){
			//新闻修改
			List<News> news = newsService.SelectNews();
			
			if(news !=null){
				req.setAttribute("Nnews", news);
				//转发到新闻详情
				req.getRequestDispatcher("newsManage.jsp").forward(req, resp);
			}
		}
		else if(id.equals("addTitle")){
			//添加主题
			String tname = req.getParameter("tname");
			
			int result=newsService.addTname(tname);
			if(result>0){
				//添加ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('添加主题成功');" +
	        			"location.href='addTitle.jsp';" +
	        			"</script>";
	        	out.println(js);
			}else
			{
				String js = "<script type='text/javascript'>" +
	        			"alert('添加主题失败');" +
	        			"</script>";
	        	out.println(js);
			}
			//重新显示该条新闻
	        out.flush();
	        out.close();
			
		}else if(id.equals("titleManage")){
			//主题修改
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
