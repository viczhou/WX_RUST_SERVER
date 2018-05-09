package cn.zhouweiyao.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhouweiyao.rest.dao.ShopInfoMapper;
import cn.zhouweiyao.rest.pojo.ShopInfo;
import cn.zhouweiyao.rest.pojo.ShopInfoExample;
import cn.zhouweiyao.rest.service.IShopInfoService;
import cn.zhouweiyao.rest.vo.Msg;
import cn.zhouweiyao.rest.vo.ShopInfoRegisterVo;
import cn.zhouweiyao.rest.vo.ShopInfoVo;

@Service
public class ShopInfoService implements IShopInfoService {
	@Autowired
	private ShopInfoMapper shopInfoMapper;

	@Override
	public ShopInfo getShopInfoByUserId(Integer userId) {

		ShopInfoExample example = new ShopInfoExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<ShopInfo> shops = shopInfoMapper.selectByExample(example);
		if (shops == null || shops.isEmpty()) {
			return null;
		}

		return shops.get(0);
	}

	@Override
	public Msg updateShopStatus(Integer shop_id, Byte status) {

		if (shop_id == null) {
			return new Msg(1);
		}

		ShopInfo shopInfo = this.getShopInfoById(shop_id);

		if (shopInfo == null) {
			return new Msg(1);
		}
		status = (status == null) ? (byte) 0 : status;
		shopInfo.setShopStatus(status);
		shopInfoMapper.updateByPrimaryKey(shopInfo);
		return new Msg(0);
	}

	@Override
	public ShopInfo getShopInfoById(Integer shop_id) {
		return shopInfoMapper.selectByPrimaryKey(shop_id);
	}

	@Override
	public ShopInfo saveShopInfo(Integer user_id, String shop_name, String shop_license, String shop_phone, String resp_name,
			String resp_phone, String shop_address, String longitude, String latitude, String shop_img) {
		
		ShopInfo shopInfo = new ShopInfo();
		shopInfo.setUserId(user_id);
		shopInfo.setShopName(shop_name);
		shopInfo.setShopLicence(shop_license);
		shopInfo.setShopPhone(shop_phone);
		shopInfo.setRespName(resp_name);
		shopInfo.setRespPhone(resp_phone);
		shopInfo.setShopAddress(shop_address);
		shopInfo.setShopLongitude(longitude);
		shopInfo.setShopLatitude(latitude);
		shopInfo.setShopImg(shop_img);
		
		shopInfo.setShopStatus((byte)0);
		
		int id = shopInfoMapper.insert(shopInfo);
		
		return shopInfo;
	}

	@Override
	public void updateShopInfo(ShopInfo shopInfo) {
		this.shopInfoMapper.updateByPrimaryKey(shopInfo);
	}

}
