package com.news.pojo;

import java.io.Serializable;
/**
 * ����ʵ����
 * @author yin
 *
 */
public class Topic implements Serializable {
	private int tid;//����id
	private String tname;//������
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
