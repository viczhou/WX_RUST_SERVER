package cn.zhouweiyao.rest.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhouweiyao.rest.dao.ShopFoodMapper;
import cn.zhouweiyao.rest.pojo.ShopFood;
import cn.zhouweiyao.rest.service.IShopFoodService;
import cn.zhouweiyao.rest.utils.ApiResult;

@Service
public class ShopFoodService implements IShopFoodService{
	@Autowired
	private ShopFoodMapper shopFoodMapper;
	@Override
	public ShopFood saveShopFood(Integer menu_id,String food_name , String food_img, String food_price) {
		
		ShopFood food = new ShopFood();
		food.setFoodName(food_name);
		food.setFoodImg(food_img);
		food.setMenuId(menu_id);
		food.setFoodPrice(new BigDecimal(food_price));
		
		shopFoodMapper.insert(food);
		return food;
	}
	@Override
	public void updateShopFood(ShopFood shopFood) {
		shopFoodMapper.updateByPrimaryKey(shopFood);
	}
	@Override
	public ShopFood getShopFoodById(Integer food_id) {
		return this.shopFoodMapper.selectByPrimaryKey(food_id);
	}
	@Override
	public void deleteShopFoodById(Integer food_id) {
		this.shopFoodMapper.deleteByPrimaryKey(food_id);
	}
	@Override
	public List<ShopFood> getShopFoodByMenuId(Integer menu_id) {
		return shopFoodMapper.selectShopFoodByMenuId(menu_id);
	}

}
