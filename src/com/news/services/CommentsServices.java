package com.news.services;

import java.util.Date;
import java.util.List;

import com.news.pojo.Comments;

public interface CommentsServices {
	public int saveComments(int cnid,String ccontent,String cip,String cauthor, Date cdate);
	public List<Comments> getCommentsByNid(int cnid);
	public int updateTopicByTid(int tid,String tname);
	public int deleteTopicByTid(int tid);
}
