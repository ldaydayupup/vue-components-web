package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.news.pojo.News;

/**
 * ����ģ���  dao  �ӿ�
 * @author yin
 *
 */
public interface NewsDao {
	/**
	 * ͨ�� tid ��ȡ�����б�
	 * @param tid
	 * @param row
	 * @param size
	 * @return   news  :nid  biaoti ʱ��
	 */
	public List<News> getNewsByTid(int tid, int row, int size);
	/**
	 * ��ҳ��ȡȫ������
	 * @param i  �ڼ�ҳ
	 * @param j   ҳ���С
	 * @return
	 */
	//��ѯ����ȫ������
	public List<News> SelectNews();
	
	public List<News> getAllNews(int row, int size);
	
	public int getAllNewsCount();

	public int getAllNewsCount(@Param("tid")int tid);
	
	public News selectNewsByNid(int nid);
	
	public int addTname(@Param("tname") String tname);
	
	public int addNews(News news);
}
