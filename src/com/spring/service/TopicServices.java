package com.spring.service;

import java.util.List;

import com.news.pojo.Topic;

/**
 * ��������ķ���ӿ�
 * @author yin
 *
 */
public interface TopicServices {
	
	/**
	 * ��ȡȫ�������������б�
	 * @return
	 * @throws Exception 
	 */
	public List<Topic> getAllTopic();

	
}
