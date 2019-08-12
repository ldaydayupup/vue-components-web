package com.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {

	/**
	 * 工具类
	 * @param args
	 */
	//全生命周期,单例模式才可声明成静态
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
		//一旦创建必须关闭，一旦关闭需重新创建
	}

}
