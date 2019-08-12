package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.news.pojo.News;

/**
 * 新闻模块的  dao  接口
 * @author yin
 *
 */
public interface NewsDao {
	/**
	 * 通过 tid 获取新闻列表
	 * @param tid
	 * @param row
	 * @param size
	 * @return   news  :nid  biaoti 时间
	 */
	public List<News> getNewsByTid(int tid, int row, int size);
	/**
	 * 分页获取全部新闻
	 * @param i  第几页
	 * @param j   页面大小
	 * @return
	 */
	//查询新闻全部内容
	public List<News> SelectNews();
	
	public List<News> getAllNews(int row, int size);
	
	public int getAllNewsCount();

	public int getAllNewsCount(@Param("tid")int tid);
	
	public News selectNewsByNid(int nid);
	
	public int addTname(@Param("tname") String tname);
	
	public int addNews(News news);
}
