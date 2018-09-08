package cn.wzb.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wzb.ssm.mapper.CateMapper;
import cn.wzb.ssm.mapper.CateMapperCustom;
import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.service.CateService;

@Service
public class CateServiceImpl implements CateService{
	@Autowired
	private CateMapperCustom cateMapperCustom;
	
	@Autowired
	private CateMapper cateMapper;
	

	@Override
	public List<Cate> findCateList() {
		
		return cateMapperCustom.findCateList();
	}

	@Override
	public void delCate(Integer id) {
		
		cateMapperCustom.delCate(id);
	}

	@Override
	public Cate findCateName(String catename) {
		Cate cate = new Cate();
		cate.setCatename(catename);
		return cateMapperCustom.findCateName(cate);
	}
	
	@Override
	public void insertCate(Cate cate) {

		cateMapper.insertSelective(cate);
	}
	
	@Override
	public Cate findCateById(Integer id) {

		Cate cate = cateMapper.selectByPrimaryKey(id);

		return cate;
	}
	
	@Override
	public void updateCate(Integer id, Cate cate) {
		cate.setId(id);
		cate.setIsdelete(0);
		cateMapper.updateByPrimaryKey(cate);
	}

}
