package cn.wzb.ssm.service;

import java.util.List;

import cn.wzb.ssm.po.Cate;

public interface CateService {
	public List<Cate> findCateList();
	public Cate findCateName(String catename);
	public void delCate(Integer id);
	public void insertCate(Cate cate);
	public Cate findCateById(Integer id);
	public void updateCate(Integer id, Cate cate);
}
