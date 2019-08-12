package com.mybatis.service;

import com.news.pojo.Users;

public interface UserService {
	public Users getUser(String username,String password);
	int regUser(Users u);
	int regUser(String username, String userpassword);
}
