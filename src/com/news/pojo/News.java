package com.news.pojo;

import java.util.Date;
/**
 * 新闻实体类
 * @author yin
 *
 */
public class News {
	private int nid;//新闻id
	private int ntid;//对应主题id
	private String ntitle;//标题
	private String ntname;
	public String getNtname() {
		return ntname;
	}
	public void setNtname(String ntname) {
		this.ntname = ntname;
	}
	private String nauthor;//作者
	private Date ncreateDate;//创建时间
	private String npicPath;//图片路径
	private String ncontent;//新闻内容
	private Date nmodifyDate;//浏览时间
	private String nsummary;//新闻摘要
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public Date getNcreateDate() {
		return ncreateDate;
	}
	public void setNcreateDate(Date ncreateDate) {
		this.ncreateDate = ncreateDate;
	}
	public String getNpicPath() {
		return npicPath;
	}
	public void setNpicPath(String npicPath) {
		this.npicPath = npicPath;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNmodifyDate() {
		return nmodifyDate;
	}
	public void setNmodifyDate(Date nmodifyDate) {
		this.nmodifyDate = nmodifyDate;
	}
	public String getNsummary() {
		return nsummary;
	}
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
	
	
}
