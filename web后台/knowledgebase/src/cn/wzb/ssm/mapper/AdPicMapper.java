package cn.wzb.ssm.mapper;

import cn.wzb.ssm.po.AdPic;
import cn.wzb.ssm.po.AdPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdPicMapper {
    int countByExample(AdPicExample example);

    int deleteByExample(AdPicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdPic record);

    int insertSelective(AdPic record);

    List<AdPic> selectByExample(AdPicExample example);

    AdPic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdPic record, @Param("example") AdPicExample example);

    int updateByExample(@Param("record") AdPic record, @Param("example") AdPicExample example);

    int updateByPrimaryKeySelective(AdPic record);

    int updateByPrimaryKey(AdPic record);
}