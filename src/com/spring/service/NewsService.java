package com.spring.service;

import java.util.List;

import com.news.pojo.News;

/**
 * ��������ģ��ķ����
 * @author yin
 *
 */
public interface NewsService {
	/**
	 * ͨ�����ŵ������id  ��ȡ�����б�
	 * @param tid  
	 * @param row  �ڼ�ҳ
	 * @param size  һҳ������
	 * @return
	 */
	public List<News> getNewsByTid(int tid,int row,int size);
	/**
	 * ��ҳ��ȡȫ������
	 * @param i  �ڼ�ҳ
	 * @param j   ҳ���С
	 * @return
	 */
	public List<News> getAllNews(int i, int j);
	public int getAllNewsCount();
	public int getAllNewsCount(int tid);
	
	public News selectNewsByNid(int nid);
	
	public int addTname(String tname);
	public int addNews(News news);
	public List<News> SelectNews();
}
