package com.news.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻评论实体类
 * @author yin
 *
 */
public class Comments implements Serializable{
	private int cid;//评论id
	private int cnid;//对应新闻的id
	private String ccontent;//评论内容
	private Date cdate;//创建时间
	private String cip;//评论的ip
	private String cauthor;//评论的作者
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCnid() {
		return cnid;
	}
	public void setCnid(int cnid) {
		this.cnid = cnid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	
	
}
