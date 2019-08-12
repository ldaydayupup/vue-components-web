package com.mybatis.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.pojo.Comments;

public interface CommentsDao {
	public int saveComments(int cnid,String ccontent,String cip,String cauthor,Date cdate);
	public List<Comments> getCommentsByNid(@Param("cnid") int cnid);
	public int updateTopicByTid(@Param("tid") int tid,@Param("tname") String tname);
	public int deleteTopicByTid(@Param("tid") int tid);
}
