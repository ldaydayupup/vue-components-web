package com.spring.service;

import java.util.List;

import com.news.pojo.Topic;

/**
 * 新闻主题的服务接口
 * @author yin
 *
 */
public interface TopicServices {
	
	/**
	 * 获取全部的新闻主题列表
	 * @return
	 * @throws Exception 
	 */
	public List<Topic> getAllTopic();

	
}
