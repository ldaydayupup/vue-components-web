package com.news.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.news.dao.CommentsDaoImpl;
import com.news.dao.NewsDao;
import com.news.dao.NewsDaoImpl;
import com.news.pojo.News;
import com.news.utill.DatabaseUtil;
/**
 * 新闻模块的服务层   ----dao
 * @author yin
 *
 */

public class NewsServiceImpl implements NewsService {
	NewsDao dao ;
	@Override
	public List<News> getNewsByTid(int tid, int row, int size) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.getNewsByTid(tid, row, size);
	}
	@Override
	public List<News> getAllNews(int row, int size) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.getAllNews(row, size);
	}
	@Override
	public int getAllNewsCount() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.getAllNewsCount();
	}
	@Override
	public int getAllNewsCount(int tid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.getAllNewsCount(tid);
	}
	@Override
	public News selectNewsByNid(int nid) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.selectNewsByNid(nid);
	}
	@Override
	public int addTname(String tname) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.addTname(tname);
	}
	@Override
	public int addNews(News news) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.addNews(news);
	}
	@Override
	public List<News> SelectNews() {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new NewsDaoImpl(conn);
		return dao.SelectNews();
	}

}
