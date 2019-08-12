package com.mybatis.service;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.UsersDao;
import com.mybatis.util.MybatisUtil;
import com.news.pojo.Users;


public class UserServices implements UserService {

	@Override
	public Users getUser(String username, String password) {
		Users user =null;
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getsqlSession();
			UsersDao dao = sqlSession.getMapper(UsersDao.class);
			user = dao.login(username, password);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally{
			MybatisUtil.closeSqlSession(sqlSession);
		}
		return user;
	}

	@Override
	public int regUser(Users u) {
		int res = 0;
		SqlSession sqlSession =null;
		try {
		sqlSession = MybatisUtil.getsqlSession();
		UsersDao dao = sqlSession.getMapper(UsersDao.class);
		res = dao.addUser(u);
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
	public int regUser(String username, String userpassword) {
		// TODO Auto-generated method stub
		return 0;
	}
}
