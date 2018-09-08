package cn.wzb.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.wzb.ssm.po.Tag;
@Repository
public interface TagMapperCustom {

	public List<Tag> findTagList();
	public Tag findTagName(Tag tag);
	public void delTag(Integer id);

}
