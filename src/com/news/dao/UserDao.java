package com.news.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.pojo.Users;



public class UserDao extends BaseDao {
	public UserDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public Users loginUser(String username,String password){
		Users user =null;
		ResultSet res =null;
		
		try {
			String sql = "select * from news_users where uname =? and upwd =?";
			res = executeQuery(sql,username,password);
			if(res.next()){
				user = new Users();
				user.setUname(res.getString("uname"));
				user.setUpwd(res.getString("upwd"));
				user.setType(res.getString("type"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	
	public int regUser(String username,String userpassword){
		int result = 0;

		try {
			String sql = "insert into news_users(uname,upwd) value(?,?)";
			result = executeUpdate(sql, username,userpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = 0;
			e.printStackTrace();
		}
		
		
		return result;
	}
}
