package com.news.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.news.dao.CommentsDao;
import com.news.dao.CommentsDaoImpl;
import com.news.dao.NewsDaoImpl;
import com.news.pojo.Comments;
import com.news.utill.DatabaseUtil;

public class CommentsServicesImpl implements CommentsServices {
	CommentsDao dao;
	@Override
	public int saveComments(int cnid, String ccontent, String cip,
			String cauthor,Date cdate) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new CommentsDaoImpl(conn);
		return dao.saveComments(cnid, ccontent, cip, cauthor,cdate);
	}
	@Override
	public List<Comments> getCommentsByNid(int cnid) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new CommentsDaoImpl(conn);
		return dao.getCommentsByNid(cnid);
	}
	@Override
	public int updateTopicByTid(int tid, String tname) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new CommentsDaoImpl(conn);
		return dao.updateTopicByTid(tid, tname);
	}
	@Override
	public int deleteTopicByTid(int tid) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new CommentsDaoImpl(conn);
		return dao.deleteTopicByTid(tid);
	}
	
}
