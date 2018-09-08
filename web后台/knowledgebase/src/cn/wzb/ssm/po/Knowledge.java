package cn.wzb.ssm.po;

import java.util.Date;

public class Knowledge {
    private Integer id;

    private String title;

    private String knowledgecontent;

    private String time;

    private Integer userid;

    private Integer cateid;

    private Integer sfshare;
    
    private Integer count;

    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKnowledgecontent() {
        return knowledgecontent;
    }

    public void setKnowledgecontent(String knowledgecontent) {
        this.knowledgecontent = knowledgecontent == null ? null : knowledgecontent.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String string) {
        this.time = string;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public Integer getSfshare() {
        return sfshare;
    }

    public void setSfshare(Integer sfshare) {
        this.sfshare = sfshare;
    }
}