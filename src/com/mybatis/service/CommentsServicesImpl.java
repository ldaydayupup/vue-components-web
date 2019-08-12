package com.mybatis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.CommentsDao;
import com.mybatis.dao.UsersDao;
import com.mybatis.util.MybatisUtil;
import com.news.pojo.Comments;

public class CommentsServicesImpl implements CommentsServices {

	@Override
	public int saveComments(int cnid, String ccontent, String cip,
			String cauthor, Date cdate) {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		CommentsDao dao = sqlSession.getMapper(CommentsDao.class);
		res = dao.saveComments(cnid, ccontent, cip, cauthor, cdate);
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
	public List<Comments> getCommentsByNid(int cnid) {
		SqlSession sqlSession = null;
		List<Comments> data = null;
		try {
			sqlSession = MybatisUtil.getsqlSession();
			CommentsDao dao = sqlSession.getMapper(CommentsDao.class);
			data = dao.getCommentsByNid(cnid);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return data;
	}

	@Override
	public int updateTopicByTid(int tid, String tname) {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		CommentsDao dao = sqlSession.getMapper(CommentsDao.class);
		res = dao.updateTopicByTid(tid, tname);
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
	public int deleteTopicByTid(int tid) {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		CommentsDao dao = sqlSession.getMapper(CommentsDao.class);
		res = dao.deleteTopicByTid(tid);
		sqlSession.commit();
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return res;
	}

}
