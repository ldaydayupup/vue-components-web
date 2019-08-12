package com.spring.service;

import java.util.List;

import com.news.pojo.News;

/**
 * 定义新闻模块的服务层
 * @author yin
 *
 */
public interface NewsService {
	/**
	 * 通过新闻的主题的id  获取新闻列表
	 * @param tid  
	 * @param row  第几页
	 * @param size  一页有数据
	 * @return
	 */
	public List<News> getNewsByTid(int tid,int row,int size);
	/**
	 * 分页获取全部新闻
	 * @param i  第几页
	 * @param j   页面大小
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
