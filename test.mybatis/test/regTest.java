package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.CommentsDao;
public class regTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		SqlSession sqlsession = null;
		
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			sqlsession = factory.openSession();
			CommentsDao dao = sqlsession.getMapper(CommentsDao.class);
			
			int res = dao.deleteTopicByTid(1);
			
			System.out.println(res);
			sqlsession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			sqlsession.close();
		}
	}
}
