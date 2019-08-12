package com.news.dao;

import java.util.List;

import com.news.pojo.Topic;

public interface TopicDao {
	
	List<Topic> getAllTopic() throws Exception;
	
}
