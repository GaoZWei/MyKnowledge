package cn.wzb.ssm.service;

import java.util.List;

import cn.wzb.ssm.po.Collect;
import cn.wzb.ssm.po.CollectCustom;
import cn.wzb.ssm.po.User;

public interface CollectionService {

	public void insert(Collect record) ;


	List<CollectCustom> findKnowledgeIdByUserId(User user);


	public void deleteCollection(Integer id) ;


	public CollectCustom getEntity(Integer id);
}
