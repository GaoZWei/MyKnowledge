package cn.wzb.ssm.mapper;

import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.po.CateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CateMapper {
    int countByExample(CateExample example);

    int deleteByExample(CateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cate record);

    int insertSelective(Cate record);

    List<Cate> selectByExample(CateExample example);

    Cate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cate record, @Param("example") CateExample example);

    int updateByExample(@Param("record") Cate record, @Param("example") CateExample example);

    int updateByPrimaryKeySelective(Cate record);

    int updateByPrimaryKey(Cate record);
}