package com.spring.service;

import com.mybatis.dao.UsersDao;

import com.news.pojo.Users;


public class UserServicesImpl implements UserServices {

	UsersDao userdao;
	
	public UsersDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public Users getUser(String username, String password) {
		
		return userdao.login(username, password);
	}

	@Override
	public int regUser(Users u) {
		
		return userdao.addUser(u);
	}

}
