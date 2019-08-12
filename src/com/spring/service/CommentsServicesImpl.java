package com.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mybatis.dao.CommentsDao;

import com.news.pojo.Comments;

public class CommentsServicesImpl implements CommentsServices {
	CommentsDao commdao ;

	public CommentsDao getCommdao() {
		return commdao;
	}

	public void setCommdao(CommentsDao commdao) {
		this.commdao = commdao;
	}

	@Override
	public int saveComments(int cnid, String ccontent, String cip,
			String cauthor, Date cdate) {
		// TODO Auto-generated method stub
		return commdao.saveComments(cnid, ccontent, cip, cauthor, cdate);
	}

	@Override
	public List<Comments> getCommentsByNid(int cnid) {
		// TODO Auto-generated method stub
		return commdao.getCommentsByNid(cnid);
	}

	@Override
	public int updateTopicByTid(int tid, String tname) {
		// TODO Auto-generated method stub
		return commdao.updateTopicByTid(tid, tname);
	}

	@Override
	public int deleteTopicByTid(int tid) {
		// TODO Auto-generated method stub
		return commdao.deleteTopicByTid(tid);
	}
}
