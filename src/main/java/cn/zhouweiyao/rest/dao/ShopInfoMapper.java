package cn.zhouweiyao.rest.dao;

import cn.zhouweiyao.rest.pojo.ShopInfo;
import cn.zhouweiyao.rest.pojo.ShopInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopInfoMapper {
    int countByExample(ShopInfoExample example);

    int deleteByExample(ShopInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    List<ShopInfo> selectByExample(ShopInfoExample example);

    ShopInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopInfo record, @Param("example") ShopInfoExample example);

    int updateByExample(@Param("record") ShopInfo record, @Param("example") ShopInfoExample example);

    int updateByPrimaryKeySelective(ShopInfo record);

    int updateByPrimaryKey(ShopInfo record);
}