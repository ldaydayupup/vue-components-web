package com.mybatis.dao;

import com.news.pojo.Users;


public interface UsersDao {
	//×¢²á
	int addUser(Users u);
	//µÇÂ¼
	Users login(String name, String pwd);
}
