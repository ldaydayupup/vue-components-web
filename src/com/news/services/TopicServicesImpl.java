package com.news.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.news.dao.TopicDao;
import com.news.dao.TopicDaoImpl;
import com.news.pojo.Topic;
import com.news.utill.DatabaseUtil;
/**
 * ��������  ����  �ӿ�ʵ����
 * @author yin
 *
 */
public class TopicServicesImpl  implements TopicServices {
	TopicDao dao;
	@Override
	public List<Topic> getAllTopic() {
		// TODO Auto-generated method stub
		Connection conn = null;
		//��ȡ���Ӷ���
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
