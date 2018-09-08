package cn.wzb.ssm.mapper;

import cn.wzb.ssm.po.Knowledge;
import cn.wzb.ssm.po.KnowledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeMapper {
    int countByExample(KnowledgeExample example);

    int deleteByExample(KnowledgeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Knowledge record);

    int insertSelective(Knowledge record);

    List<Knowledge> selectByExample(KnowledgeExample example);

    Knowledge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByExample(@Param("record") Knowledge record, @Param("example") KnowledgeExample example);

    int updateByPrimaryKeySelective(Knowledge record);

    int updateByPrimaryKey(Knowledge record);
}