package com.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.TopicDao;
import com.mybatis.util.MybatisUtil;
import com.news.pojo.Topic;

public class TopicServicesImpl implements TopicServices {
	TopicDao dao ;

	public TopicDao getDao() {
		return dao;
	}

	public void setDao(TopicDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Topic> getAllTopic(){
		// TODO Auto-generated method stub
		return dao.getAllTopic();
	}
	
}
