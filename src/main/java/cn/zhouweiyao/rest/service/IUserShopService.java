package cn.zhouweiyao.rest.service;

import cn.zhouweiyao.rest.pojo.UserShop;
import cn.zhouweiyao.rest.vo.Msg;

public interface IUserShopService {
	
	UserShop getUserById(Integer user_id);
	UserShop getUserByPhone(String phone);
	Msg saveUserShopRegister(String phone, String password);
	UserShop getUserByPhoneAndPassword(String phone, String password);
	Msg updatePassword(Integer user_id, String old_password, String new_password);
	Msg updatePhone(Integer user_id, String phone);
	
}
