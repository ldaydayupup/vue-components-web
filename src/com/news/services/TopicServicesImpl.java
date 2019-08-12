package com.news.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.news.dao.TopicDao;
import com.news.dao.TopicDaoImpl;
import com.news.pojo.Topic;
import com.news.utill.DatabaseUtil;
/**
 * 新闻主题  服务  接口实现类
 * @author yin
 *
 */
public class TopicServicesImpl  implements TopicServices {
	TopicDao dao;
	@Override
	public List<Topic> getAllTopic() {
		// TODO Auto-generated method stub
		Connection conn = null;
		//获取连接对象
		try {
			conn = DatabaseUtil.getConnection();
			dao = new TopicDaoImpl(conn);
			return dao.getAllTopic();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
