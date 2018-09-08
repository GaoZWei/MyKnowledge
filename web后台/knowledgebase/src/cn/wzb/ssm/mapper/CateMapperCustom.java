package cn.wzb.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.wzb.ssm.po.Cate;
@Repository
public interface CateMapperCustom {
	public List<Cate> findCateList();
	public Cate findCateName(Cate cate);
	public void delCate(Integer id);
}
