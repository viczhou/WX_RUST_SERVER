package cn.zhouweiyao.rest.dao;

import cn.zhouweiyao.rest.pojo.ShopMenu;
import cn.zhouweiyao.rest.pojo.ShopMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopMenuMapper {
    int countByExample(ShopMenuExample example);

    int deleteByExample(ShopMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopMenu record);

    int insertSelective(ShopMenu record);

    List<ShopMenu> selectByExample(ShopMenuExample example);

    ShopMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopMenu record, @Param("example") ShopMenuExample example);

    int updateByExample(@Param("record") ShopMenu record, @Param("example") ShopMenuExample example);

    int updateByPrimaryKeySelective(ShopMenu record);

    int updateByPrimaryKey(ShopMenu record);
}