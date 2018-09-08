package cn.wzb.ssm.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.po.CollectCustom;
import cn.wzb.ssm.po.KnowledgeCustom;
import cn.wzb.ssm.po.KnowledgeQueryVo;
import cn.wzb.ssm.po.TagCustom;
import cn.wzb.ssm.po.User;

@Repository
public interface KnowledgeMapperCustom {
	
	public List<KnowledgeCustom> findUserKnowledgeList(Integer id);
	
	public List<KnowledgeCustom> findOnlineKnowledgeList(KnowledgeQueryVo knowledgeQueryVo);
	
	public List<KnowledgeCustom> findHotKnowledgeList(KnowledgeQueryVo knowledgeQueryVo);
	
	public List<KnowledgeCustom> findSameTypeKnowledgeList(Integer cateid);

	public List<KnowledgeCustom> findSameTagKnowledgeList(Integer tagid);

	public List<KnowledgeCustom> findKnowledgeinf(Integer id);
	
	public List<KnowledgeCustom> findKnowledgeSelByName(String title);
	
	public void deleteByPrimaryKey(Integer id);
	
	public void isdeleteKnowledge(Integer id) ;

	public void nodeleteKnowledge(Integer id) ;

	public List<KnowledgeCustom> findShareKnowledgeByUserId(Integer id);

	KnowledgeCustom getEntity(Integer id);

	public List<Cate> findKnowledgecatelist(Integer id);

	public void updateCount(KnowledgeCustom knowledgeCustom);

	public List<CollectCustom> findTaglist(Integer id);

	public KnowledgeCustom findEntityByName(String title);

}
