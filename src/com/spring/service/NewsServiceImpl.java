package com.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.NewsDao;
import com.mybatis.dao.UsersDao;
import com.mybatis.util.MybatisUtil;
import com.news.pojo.News;
import com.news.pojo.Users;

public class NewsServiceImpl implements NewsService {
	
	NewsDao newsdao;
	
	
	public NewsDao getNewsdao() {
		return newsdao;
	}

	public void setNewsdao(NewsDao newsdao) {
		this.newsdao = newsdao;
	}

	@Override
	public List<News> getNewsByTid(int tid, int row, int size) {
		
		return newsdao.getNewsByTid(tid, row, size);
	}

	@Override
	public List<News> getAllNews(int i, int j) {
		
		return newsdao.getAllNews(i, j);
	}

	@Override
	public int getAllNewsCount() {
		
		return newsdao.getAllNewsCount();
	}

	@Override
	public int getAllNewsCount(int tid) {
		
		return newsdao.getAllNewsCount(tid);
	}

	@Override
	public News selectNewsByNid(int nid) {
		
		return newsdao.selectNewsByNid(nid);
	}

	@Override
	public int addTname(String tname) {
		
		return newsdao.addTname(tname);
	}

	@Override
	public int addNews(News news) {
		
		return newsdao.addNews(news);
	}

	@Override
	public List<News> SelectNews() {
		
		return newsdao.SelectNews();
	}

}
