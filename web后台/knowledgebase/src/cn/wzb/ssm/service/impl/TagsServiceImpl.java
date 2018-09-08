package cn.wzb.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.wzb.ssm.mapper.TagsMapper;
import cn.wzb.ssm.po.Tags;
import cn.wzb.ssm.service.TagsService;

@Service
public class TagsServiceImpl implements TagsService{

	@Autowired
	private TagsMapper tagsMapper;
	
	@Override
	public void insertTag(Tags tags) {
		tagsMapper.insert(tags);
	}

}
