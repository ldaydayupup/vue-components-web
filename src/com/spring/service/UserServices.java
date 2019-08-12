package com.spring.service;

import com.news.pojo.Users;

public interface UserServices {
	public Users getUser(String username,String password);
	int regUser(Users u);
}
