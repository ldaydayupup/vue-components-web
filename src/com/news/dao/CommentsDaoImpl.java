package com.news.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.news.pojo.Comments;
import com.news.utill.DatabaseUtil;



public class CommentsDaoImpl extends BaseDao implements CommentsDao {

	public CommentsDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}


	@Override
	public int saveComments(int cnid, String ccontent, String cip,
			String cauthor,Date cdate) {
		int result = 0;
		try {
			String sql = "insert into comments(cnid,ccontent,cip,cauthor,cdate) value(?,?,?,?,?)";
			
			result = executeUpdate(sql, cnid,ccontent,cip,cauthor,cdate);
			if(result>0){
				result++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public List<Comments> getCommentsByNid(int cnid) {
		List<Comments> commentsList = new ArrayList<Comments>();
		Comments comments = new Comments();
		ResultSet res = null;
		
		try {
			String sql = "SELECT * FROM comments WHERE cnid=?";
			res = executeQuery(sql, cnid);
			while(res.next()){
				comments = new Comments();
				comments.setCnid(res.getInt("cnid"));
				comments.setCcontent(res.getString("ccontent"));
				comments.setCip(res.getString("cip"));
				comments.setCauthor(res.getString("cauthor"));
				comments.setCdate(res.getDate("cdate"));
				commentsList.add(comments);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, null, res);
		}
		return commentsList;
	}


	@Override
	public int updateTopicByTid(int tid, String tname) {
		int result = 0;
		try {
			String sql = "update topic set tname =? where tid=?";
			
			result = executeUpdate(sql,tname,tid);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public int deleteTopicByTid(int tid) {
		int result = 0;
		try {
			String sql = "delete from topic where tid=?";
			
			result = executeUpdate(sql,tid);
			
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}
		
		return result;
	}

}
