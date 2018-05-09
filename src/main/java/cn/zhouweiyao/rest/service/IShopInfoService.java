package cn.zhouweiyao.rest.service;

import cn.zhouweiyao.rest.pojo.ShopInfo;
import cn.zhouweiyao.rest.vo.Msg;

public interface IShopInfoService {
	ShopInfo getShopInfoByUserId(Integer userId);
	Msg updateShopStatus(Integer shop_id, Byte status);
	ShopInfo getShopInfoById(Integer shop_id);
	ShopInfo saveShopInfo(Integer user_id, String shop_name, String shop_license, String shop_phone, String resp_name,
			String resp_phone, String shop_address, String longitude, String latitude, String shop_img);
	void updateShopInfo(ShopInfo shopInfo);
}
