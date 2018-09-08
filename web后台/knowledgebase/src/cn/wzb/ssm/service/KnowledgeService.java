package cn.wzb.ssm.service;

import java.util.List;

import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.po.CollectCustom;
import cn.wzb.ssm.po.KnowledgeCustom;
import cn.wzb.ssm.po.KnowledgeQueryVo;
import cn.wzb.ssm.po.Tag;
import cn.wzb.ssm.po.TagCustom;
import cn.wzb.ssm.po.User;

public interface KnowledgeService {
	
	public List<KnowledgeCustom> findUserKnowledgeList(Integer id);
	
	public void findTagById(Integer id);

	public void insertKnowledge(KnowledgeCustom knowledgeCustom);

	public void deleteknowledge(Integer id);

	public KnowledgeCustom findKnowledgeById(Integer id);

	public void updateKnowledge(Integer id, KnowledgeCustom knowledgeCustom);
	
	public void isdeleteKnowledge(Integer id);

	public void nodeleteKnowledge(Integer id);
	
	public List<KnowledgeCustom> findOnlineKnowledgeList(KnowledgeQueryVo knowledgeQueryVo);
	
	public List<KnowledgeCustom> findHotKnowledgeList(KnowledgeQueryVo knowledgeQueryVo);

	public List<KnowledgeCustom> findSameTypeKnowledgeList(Integer cateid);

	public List<KnowledgeCustom> findSameTagKnowledgeList(Integer tagid);

	public List<KnowledgeCustom> findKnowledgeinf(Integer id);

	public List<KnowledgeCustom> findKnowledgeSelByName(String title);

	public List<KnowledgeCustom> findShareKnowledgeByUserId(Integer id);

	public KnowledgeCustom getEntity(Integer id);

	public List<Cate> findKnowledgecatelist(Integer id);

	public void updateCount(Integer id, KnowledgeCustom knowledgeCustom);

	public List<CollectCustom> findTaglist(Integer id);

	public void isdelshare(Integer id);

	public KnowledgeCustom findEntityByName(String title);
	
}
