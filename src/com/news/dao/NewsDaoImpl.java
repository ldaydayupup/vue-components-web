package com.news.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.pojo.News;
import com.news.utill.DatabaseUtil;

public class NewsDaoImpl extends BaseDao implements NewsDao{

	public NewsDaoImpl(Connection conn) {
		super(conn);

	}

	@Override
	public List<News> getNewsByTid(int tid, int row, int size) {
		String sql = "SELECT * FROM news WHERE ntid = ? LIMIT ?,?";
		List<News> data = new ArrayList<News>();
		ResultSet res = null ;
		try {
			res = executeQuery(sql,tid,row,size);
			//处理结果集
			while(res.next())
			{
				News news = new News();
				news.setNid(res.getInt("nid"));
				news.setNtitle(res.getString("ntitle"));
				news.setNcreateDate(res.getDate("ncreateDate"));
				data.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, null, res);
		}
		
		return data;
	}

	@Override
	public List<News> getAllNews(int row, int size) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM news LIMIT ?,?";
		List<News> data = new ArrayList<News>();
		ResultSet res = null ;
		try {
			res = executeQuery(sql,row,size);
			//处理结果集
			while(res.next())
			{
				News news = new News();
				news.setNid(res.getInt("nid"));
				news.setNtitle(res.getString("ntitle"));
				news.setNcreateDate(res.getDate("ncreateDate"));
				data.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, null, res);
		}
		
		return data;
	}

	
	/**
	 * 获取新闻的总条数
	 */
	@Override
	public int getAllNewsCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from news";
		ResultSet res = null ;
		int count = 0;
		try {
			res = executeQuery(sql);
			if(res.next()){
				count = res.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, null, res);
		}
		return count;
	}

	@Override
	public int getAllNewsCount(int tid) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from news where ntid=?";
		ResultSet res = null ;
		int count = 0;
		try {
			res = executeQuery(sql,tid);
			if(res.next()){
				count = res.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, null, res);
		}
		return count;
	}
//查询指定id新闻
	@Override
	public News selectNewsByNid(int nid) {
		News news = new News();
		ResultSet res = null;
		
		try {
			String sql = "SELECT * FROM news WHERE nid=?";
			res = executeQuery(sql, nid);
			if(res.next()){
				news = new News();
				news.setNid(res.getInt("nid"));
				news.setNtitle(res.getString("ntitle"));
				news.setNcreateDate(res.getDate("ncreateDate"));
				news.setNsummary(res.getString("nsummary"));
				news.setNcontent(res.getString("ncontent"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, null, res);
		}
		
		return news;
	}

	@Override
	public int addTname(String tname) {
		int result = 0;
		
		try {
			String sql = "insert into topic(tname) value(?)";
			result = executeUpdate(sql, tname);
		} catch (SQLException e) {
			result = 0;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int addNews(News news) {
		int result = 0;
		
		try {
			String sql = "insert into news(ntid,ntitle,nauthor,nsummary,ncreateDate,ncontent) value(?,?,?,?,?,?)";
			result = executeUpdate(sql, news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNsummary(),news.getNcreateDate(),news.getNcontent());
		} catch (SQLException e) {
			result = 0;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<News> SelectNews() {
		List<News> newsList = new ArrayList<News>();
		News news = null;
		ResultSet res = null;
		
		try {
			String sql = "select * from news";
			res= executeQuery(sql);
			while(res.next()){
				news = new News();
				news.setNid(res.getInt("nid"));
				news.setNtid(res.getInt("ntid"));
				news.setNtitle(res.getString("ntitle"));
				news.setNauthor(res.getString("nauthor"));
				news.setNcreateDate(res.getDate("ncreateDate"));
				news.setNpicPath(res.getString("npicPath"));
				news.setNmodifyDate(res.getDate("nmodifyDate"));
				news.setNsummary(res.getString("nsummary"));
				newsList.add(news);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, null, res);
		}
		
		return newsList;
	}


}
