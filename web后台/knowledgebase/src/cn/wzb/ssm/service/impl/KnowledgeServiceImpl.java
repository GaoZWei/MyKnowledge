package cn.wzb.ssm.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wzb.ssm.mapper.KnowledgeMapper;
import cn.wzb.ssm.mapper.KnowledgeMapperCustom;
import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.po.CollectCustom;
import cn.wzb.ssm.po.Knowledge;
import cn.wzb.ssm.po.KnowledgeCustom;
import cn.wzb.ssm.po.KnowledgeQueryVo;
import cn.wzb.ssm.po.TagCustom;
import cn.wzb.ssm.po.User;
import cn.wzb.ssm.service.KnowledgeService;
@Service
public class KnowledgeServiceImpl implements KnowledgeService{
	
	@Autowired
	private KnowledgeMapper knowledgeMapper;
	@Autowired
	private KnowledgeMapperCustom knowledgeMapperCustom;
	
	@Override
	public List<KnowledgeCustom> findUserKnowledgeList(Integer id) {
		
		return knowledgeMapperCustom.findUserKnowledgeList(id);
	}

	public void findTagById(Integer id) {
		
	}

	@Override
	public void insertKnowledge(KnowledgeCustom knowledgeCustom){
		
		knowledgeMapper.insert(knowledgeCustom);
	}

	@Override
	public void deleteknowledge(Integer id){

		   knowledgeMapperCustom.deleteByPrimaryKey(id);
	}

	@Override
	public KnowledgeCustom findKnowledgeById(Integer id){
		Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(id);

		KnowledgeCustom knowledgeCustom = new KnowledgeCustom();

		BeanUtils.copyProperties(knowledge, knowledgeCustom);

		return knowledgeCustom;
	}

	@Override
	public void updateKnowledge(Integer id, KnowledgeCustom knowledgeCustom) {
		Random r = new Random();
		knowledgeCustom.setId(id);
		knowledgeCustom.setUserid(2);
		knowledgeCustom.setSfshare(0);
		knowledgeCustom.setCount(r.nextInt(9999));
		knowledgeMapper.updateByPrimaryKey(knowledgeCustom);
		
	}

	@Override
	public void isdeleteKnowledge(Integer id) {
		knowledgeMapperCustom.isdeleteKnowledge(id);
		
	}

	@Override
	public void nodeleteKnowledge(Integer id) {
		knowledgeMapperCustom.nodeleteKnowledge(id);
		
	}

	@Override
	public List<KnowledgeCustom> findOnlineKnowledgeList(KnowledgeQueryVo knowledgeQueryVo) {
		
		return knowledgeMapperCustom.findOnlineKnowledgeList(knowledgeQueryVo);
	}

	@Override
	public List<KnowledgeCustom> findHotKnowledgeList(KnowledgeQueryVo knowledgeQueryVo) {
		
		return knowledgeMapperCustom.findHotKnowledgeList(knowledgeQueryVo);
	}

	@Override
	public List<KnowledgeCustom> findSameTypeKnowledgeList(Integer cateid) {
		return knowledgeMapperCustom.findSameTypeKnowledgeList(cateid);
	}

	@Override
	public List<KnowledgeCustom> findSameTagKnowledgeList(Integer tagid) {
		return knowledgeMapperCustom.findSameTagKnowledgeList(tagid);
	}

	@Override
	public List<KnowledgeCustom> findKnowledgeinf(Integer id) {
		return knowledgeMapperCustom.findKnowledgeinf(id);
	}

	@Override
	public List<KnowledgeCustom> findKnowledgeSelByName(String title) {
		return knowledgeMapperCustom.findKnowledgeSelByName(title);
	}

	@Override
	public List<KnowledgeCustom> findShareKnowledgeByUserId(Integer id) {
		
		return knowledgeMapperCustom.findShareKnowledgeByUserId(id);
	}

	@Override
	public KnowledgeCustom getEntity(Integer id) {
		return knowledgeMapperCustom.getEntity(id);
	}

	@Override
	public List<Cate> findKnowledgecatelist(Integer id) {
		return knowledgeMapperCustom.findKnowledgecatelist(id);
	}

	@Override
	public void updateCount(Integer id, KnowledgeCustom knowledgeCustom) {
		knowledgeCustom.setId(id);
		knowledgeMapperCustom.updateCount(knowledgeCustom);
	}

	@Override
	public List<CollectCustom> findTaglist(Integer id) {
		return knowledgeMapperCustom.findTaglist(id);
	}

	@Override
	public void isdelshare(Integer id) {
		 knowledgeMapperCustom.deleteByPrimaryKey(id);
	}

	@Override
	public KnowledgeCustom findEntityByName(String title) {
		
		return knowledgeMapperCustom.findEntityByName(title);
	}
}
