package cn.wzb.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.wzb.ssm.po.CollectCustom;
import cn.wzb.ssm.po.User;
@Repository
public interface CollectionMapperCustom {
	
	List<CollectCustom> findKnowledgeIdByUserId(User user) ;

	CollectCustom getEntity(Integer id);
	
}
