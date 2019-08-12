package com.news.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.pojo.Topic;
import com.news.utill.DatabaseUtil;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	public TopicDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Topic> getAllTopic()  throws Exception{
		// TODO Auto-generated method stub
	  List<Topic> list = new ArrayList<Topic>();
	  ResultSet rs = null;
	  // 获取所有主题
	  String sql = "select * from topic";
	  rs = executeQuery(sql);
	  Topic topic = null;
	  while (rs.next()) {
	      topic = new Topic();
	      topic.setTid(rs.getInt("tid"));
	     topic.setTname(rs.getString("tname"));
	      list.add(topic);
	     }
	  DatabaseUtil.closeAll(null, null, rs);
	   return list;
	}


}
