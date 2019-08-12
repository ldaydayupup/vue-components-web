package com.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {

	/**
	 * ������
	 * @param args
	 */
	//ȫ��������,����ģʽ�ſ������ɾ�̬
	private static SqlSessionFactory factory;
	
	static{
		String resource = "mybatis-config.xml";
		InputStream is;
		
		try {
			is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static SqlSession getsqlSession(){
		if(factory!=null)
		{
			return factory.openSession();
		}
		
		return null;
	}
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
		}
		//һ����������رգ�һ���ر������´���
	}

}
