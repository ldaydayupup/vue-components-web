package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.Comments;
import com.news.pojo.News;
import com.spring.service.CommentsServices;
import com.spring.service.NewsService;

/**
 * ����
 * Title:NewsCommentsServlet
 * @author 12782
 *
 */
public class NewsCommentsServlet extends HttpServlet {

//	private static final long serialVersionUID = 1L;
//	//��������ӿ�
//	CommentsServices commentsServices;
//	NewsService newsService;
	ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String opr = request.getParameter("opr");
		PrintWriter out = response.getWriter();
		
		if(opr.equals("addComment")){
			
			//�ύ֮������ݴ���
			int cnid =Integer.parseInt(request.getParameter("nid")) ;//����id
			String cauthor = request.getParameter("cauthor");//�û���
			String cip = request.getRemoteAddr();//IP
			String ccontent = request.getParameter("ccontent");//����
			Date cdate = new Date();
			
			CommentsServices commentsServices = (CommentsServices) context.getBean("commentsServices");
			int result=commentsServices.saveComments(cnid, ccontent, cip, cauthor,cdate);
			
			NewsService newsService = (NewsService) context.getBean("newsServiceImpl");
			//��������
			List<News> data1 = newsService.getNewsByTid(1, 0, 6);
			//��������
			List<News> data2 = newsService.getNewsByTid(2, 0, 6);
			//��������
			List<News> data3 = newsService.getNewsByTid(5, 0, 6);
			//��������

			//����
//			Comments comments = new Comments();
//			comments.setCdate(new Date());
			
			request.setAttribute("news1", data1);
			request.setAttribute("news2", data2);
			request.setAttribute("news3", data3);
			
			if(result>0){
				//���ok
	        	String js = "<script type='text/javascript'>" +
	        			"alert('������۳ɹ�');" +
	        			"location.href='news?id=readNew&nid="+cnid+"';" +
	        			"</script>";
	        	out.println(js);
			}else
			{
				String js = "<script type='text/javascript'>" +
	        			"alert('�������ʧ�ܣ�����ϵ����Ա');" +
	        			"location.href='news?id=readNew&nid="+cnid+"';" +
	        			"</script>";
	        	out.println(js);
			}
			//������ʾ��������
	        out.flush();
	        out.close();
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
