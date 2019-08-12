package com.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.NewsDao;
import com.mybatis.dao.UsersDao;
import com.mybatis.util.MybatisUtil;
import com.news.pojo.News;
import com.news.pojo.Users;

public class NewsServiceImpl implements NewsService {

	@Override
	public List<News> getNewsByTid(int tid, int row, int size) {
		SqlSession sqlSession = null;
		List<News> listNews = null;
		try {
			sqlSession = MybatisUtil.getsqlSession();
			NewsDao dao = sqlSession.getMapper(NewsDao.class);
			listNews = dao.getNewsByTid(tid, row, size);
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return listNews;
	}

	@Override
	public List<News> getAllNews(int i, int j) {
		SqlSession sqlSession = null;
		List<News> data2 = null;
		try {
			sqlSession = MybatisUtil.getsqlSession();
			NewsDao dao = sqlSession.getMapper(NewsDao.class);
			data2 = dao.getAllNews(i, j);
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return data2;
	}

	@Override
	public int getAllNewsCount() {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		NewsDao dao = sqlSession.getMapper(NewsDao.class);
		res = dao.getAllNewsCount();
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return res;
	}

	@Override
	public int getAllNewsCount(int tid) {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		NewsDao dao = sqlSession.getMapper(NewsDao.class);
		res = dao.getAllNewsCount(tid);
		sqlSession.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return res;
	}

	@Override
	public News selectNewsByNid(int nid) {
		News news =null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getsqlSession();
			NewsDao dao = sqlSession.getMapper(NewsDao.class);
			news = dao.selectNewsByNid(nid);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return news;
	}

	@Override
	public int addTname(String tname) {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		NewsDao dao = sqlSession.getMapper(NewsDao.class);
		res = dao.addTname(tname);
		sqlSession.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return res;
	}

	@Override
	public int addNews(News news) {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		NewsDao dao = sqlSession.getMapper(NewsDao.class);
		res = dao.addNews(news);
		sqlSession.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return res;
	}

	@Override
	public List<News> SelectNews() {
		SqlSession sqlSession = null;
		List<News> data3 = null;
		try {
			sqlSession = MybatisUtil.getsqlSession();
			NewsDao dao = sqlSession.getMapper(NewsDao.class);
			data3 = dao.SelectNews();
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return data3;
	}

}
