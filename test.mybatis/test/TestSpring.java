package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.news.pojo.Comments;
import com.news.pojo.Topic;
import com.spring.service.CommentsServices;
import com.spring.service.TopicServices;

public class TestSpring {

	/**
	 * 关于Spring注入的测试方法
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
	   
//		CommentsServices commentsServices = (CommentsServices) context.getBean("CommentsServices");
		TopicServices topicServices = (TopicServices) context.getBean("topicServices");
//		List<Comments> data = commentsServices.getCommentsByNid(48);
		List<Topic> data = topicServices.getAllTopic();
		
//		TopicServices topicServices = new TopicServicesImpl();
//		
//		List<Topic> data = topicServices.getAllTopic();
		
		
		System.out.println(data.size());
		
	}

}
