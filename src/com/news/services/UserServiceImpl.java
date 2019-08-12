package com.news.services;

import java.sql.Connection;
import java.sql.SQLException;

import com.news.dao.CommentsDaoImpl;
import com.news.dao.NewsDaoImpl;
import com.news.dao.UserDao;
import com.news.pojo.Users;
import com.news.utill.DatabaseUtil;



public class UserServiceImpl implements UserService {
	UserDao dao;
	@Override
	public Users getUser(String username, String password) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new UserDao(conn);
		return dao.loginUser(username, password);
	}
	@Override
	public int regUser(String username, String userpassword) {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new UserDao(conn);
		return dao.regUser(username, userpassword);
	}
	@Override
	public int regUser(Users u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
