package cn.zhouweiyao.rest.dao;

import cn.zhouweiyao.rest.pojo.ShopFood;
import cn.zhouweiyao.rest.pojo.ShopFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopFoodMapper {
    int countByExample(ShopFoodExample example);

    int deleteByExample(ShopFoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopFood record);

    int insertSelective(ShopFood record);

    List<ShopFood> selectByExample(ShopFoodExample example);

    ShopFood selectByPrimaryKey(Integer id);
    List<ShopFood> selectShopFoodByMenuId(Integer menu_id);

    int updateByExampleSelective(@Param("record") ShopFood record, @Param("example") ShopFoodExample example);

    int updateByExample(@Param("record") ShopFood record, @Param("example") ShopFoodExample example);

    int updateByPrimaryKeySelective(ShopFood record);

    int updateByPrimaryKey(ShopFood record);
}