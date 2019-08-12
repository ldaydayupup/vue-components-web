package com.news.pojo;

import java.io.Serializable;
/**
 * 主题实体类
 * @author yin
 *
 */
public class Topic implements Serializable {
	private int tid;//主题id
	private String tname;//主题名
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	
}
