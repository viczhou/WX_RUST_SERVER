package cn.zhouweiyao.rest.dao;

import cn.zhouweiyao.rest.pojo.UserShop;
import cn.zhouweiyao.rest.pojo.UserShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShopMapper {
    int countByExample(UserShopExample example);

    int deleteByExample(UserShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserShop record);

    int insertSelective(UserShop record);

    List<UserShop> selectByExample(UserShopExample example);

    UserShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserShop record, @Param("example") UserShopExample example);

    int updateByExample(@Param("record") UserShop record, @Param("example") UserShopExample example);

    int updateByPrimaryKeySelective(UserShop record);

    int updateByPrimaryKey(UserShop record);
}