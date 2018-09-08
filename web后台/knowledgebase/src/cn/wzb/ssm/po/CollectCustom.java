package cn.wzb.ssm.po;

import java.util.Date;

import cn.wzb.ssm.po.Collect;

public class CollectCustom extends Collect{
	private Integer knowledgeid;
	private String title;
	private String knowledgecontent;
	private Integer userid;
	private Date time;
	private Integer count;
	private String tagname;
	
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getKnowledgeid() {
		return knowledgeid;
	}
	public void setKnowledgeid(Integer knowledgeid) {
		this.knowledgeid = knowledgeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKnowledgecontent() {
		return knowledgecontent;
	}
	public void setKnowledgecontent(String knowledgecontent) {
		this.knowledgecontent = knowledgecontent;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
