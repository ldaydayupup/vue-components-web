package com.news.pojo;

import java.io.Serializable;

/**
 * 用户的实体类
 * @author yin
 *
 */
public class Users implements Serializable{
	private int uid;//用户的id
	private String uname;//用户名
	private String upwd;//密码
	private String type;//类型   管理员+游客
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
