package cn.wzb.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wzb.ssm.mapper.CollectionMapper;
import cn.wzb.ssm.mapper.CollectionMapperCustom;
import cn.wzb.ssm.po.Collect;
import cn.wzb.ssm.po.CollectCustom;
import cn.wzb.ssm.po.User;
import cn.wzb.ssm.service.CollectionService;
@Service
public class CollectionServiceImpl implements CollectionService{

	@Autowired
	private CollectionMapper collectionMapper;
	
	@Autowired 
	private CollectionMapperCustom collectionMapperCustom;
	
	
	@Override
	public void insert(Collect record) {
		
		collectionMapper.insert(record);
		
	}

	@Override
	public List<CollectCustom> findKnowledgeIdByUserId(User user)  {
		
		return collectionMapperCustom.findKnowledgeIdByUserId(user);
	}

	@Override
	public void deleteCollection(Integer id)  {
		
			collectionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public CollectCustom getEntity(Integer id) {
	
		return collectionMapperCustom.getEntity(id);
	}

}
