package cn.wzb.ssm.service;

import java.util.List;

import cn.wzb.ssm.po.Tag;

public interface TagService {

	public List<Tag> findTagList();
	public Tag findTagName(String tagname);
	public void delTag(Integer id);
	public void insertTag(Tag tag);
	public Tag findTagById(Integer id);
	public void updateTag(Integer id, Tag tag);

}
