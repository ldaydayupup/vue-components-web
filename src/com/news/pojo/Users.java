package com.news.pojo;

import java.io.Serializable;

/**
 * �û���ʵ����
 * @author yin
 *
 */
public class Users implements Serializable{
	private int uid;//�û���id
	private String uname;//�û���
	private String upwd;//����
	private String type;//����   ����Ա+�ο�
	
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
