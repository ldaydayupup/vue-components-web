package com.mybatis.dao;

import com.news.pojo.Users;


public interface UsersDao {
	//ע��
	int addUser(Users u);
	//��¼
	Users login(String name, String pwd);
}
