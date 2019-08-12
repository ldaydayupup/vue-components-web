package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mybatis.dao.CommentsDao;
import com.mybatis.dao.NewsDao;
import com.mybatis.dao.TopicDao;
import com.mybatis.util.MybatisUtil;
import com.news.pojo.Topic;

public class MybatisTest {

	
	@Test
	public void testName() throws Exception {
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
//		CommentsDao dao = sqlSession.getMapper(CommentsDao.class);
//		int res = dao.saveComments(48, "wodetian", "123456", "123456",new Date());
//		int res = dao.deleteTopicByTid(32);
//		NewsDao dao = sqlSession.getMapper(NewsDao.class);
//		int res = dao.addTname("bbb");
//		TopicDao dao = sqlSession.getMapper(TopicDao.class);
//		List<Topic> data = dao.getAllTopic();
//		System.out.println(data.size());
		sqlSession.commit();

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
	}
}
