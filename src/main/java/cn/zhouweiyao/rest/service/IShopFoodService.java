package cn.zhouweiyao.rest.service;

import java.util.List;

import cn.zhouweiyao.rest.pojo.ShopFood;

public interface IShopFoodService {
	ShopFood saveShopFood(Integer menu_id,String food_name, String food_img, String food_price);
	void updateShopFood(ShopFood shopFood);
	ShopFood getShopFoodById(Integer food_id);
	void deleteShopFoodById(Integer food_id);
	List<ShopFood> getShopFoodByMenuId(Integer menu_id);
}
