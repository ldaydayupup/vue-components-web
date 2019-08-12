package test;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.news.pojo.News;
import com.news.pojo.Users;
import com.spring.service.CommentsServices;
import com.spring.service.NewsService;
import com.spring.service.UserServices;

public class Test1 {
	
	//登录
	@Test
	public void testLoginUser() throws Exception {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServices userService = (UserServices) context.getBean("userServices");
		Users user = userService.getUser("sa", "sa");
		if(user != null){
			System.out.println("成功");
		}
	}
	
	//注册
	@Test
	public void testRegUser() throws Exception {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServices userService = (UserServices) context.getBean("userServices");
		Users u = new Users();
		u.setUname("kasa");
		u.setUpwd("123456");
		int res = userService.regUser(u);
		if(res>0){
			System.out.println("注册成功");
		}
	}
	
	//新闻添加
	@Test
	public void testSaveComments() throws Exception {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
		CommentsServices commentsServices = (CommentsServices) context.getBean("commentsServices");
		int res = commentsServices.saveComments(48, "2134324", "321312", "23213", new Date());
		if(res>0){
			System.out.println("添加成功");
		}
	}
	
	//新闻
	@Test
	public void testGetAllNewsCount() throws Exception {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
		
		NewsService newsService = (NewsService) context.getBean("newsServiceImpl");
		int res = newsService.getAllNewsCount(3);
		System.out.println(res);
	}
	
	@Test
	public void testSelectNews() throws Exception {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
		
		NewsService newsService = (NewsService) context.getBean("newsServiceImpl");
		
		List<News> data = newsService.getAllNews(1,2);
		System.out.println(data.size());
	}
	
}
