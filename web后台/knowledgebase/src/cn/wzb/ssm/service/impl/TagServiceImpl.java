package cn.wzb.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wzb.ssm.mapper.TagMapper;
import cn.wzb.ssm.mapper.TagMapperCustom;
import cn.wzb.ssm.po.Tag;
import cn.wzb.ssm.service.TagService;
@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagMapperCustom tagMapperCustom;
	
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> findTagList(){
	
		return tagMapperCustom.findTagList();
	}

	@Override
	public Tag findTagName(String tagname) {
		Tag tag = new Tag();
		tag.setTagname(tagname);
		return tagMapperCustom.findTagName(tag);
	}
	
	@Override
	public void insertTag(Tag tag) {

		tagMapper.insertSelective(tag);
	}

	@Override
	public void delTag(Integer id) {
		
		tagMapperCustom.delTag(id);
	}
	
	@Override
	public Tag findTagById(Integer id) {

		Tag tag = tagMapper.selectByPrimaryKey(id);

		return tag;
	}
	
	@Override
	public void updateTag(Integer id, Tag tag) {
		
		tag.setId(id);
		tag.setIsdelete(0);
		tagMapper.updateByPrimaryKey(tag);
	}

}
