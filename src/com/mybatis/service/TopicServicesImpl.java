package com.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.TopicDao;
import com.mybatis.util.MybatisUtil;
import com.news.pojo.Topic;

public class TopicServicesImpl implements TopicServices {

	@Override
	public List<Topic> getAllTopic() {
		SqlSession sqlSession = null;
		List<Topic> data4 = null;
		try {
			sqlSession = MybatisUtil.getsqlSession();
			TopicDao dao = sqlSession.getMapper(TopicDao.class);
			data4 = dao.getAllTopic();
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return data4;
	}

}
