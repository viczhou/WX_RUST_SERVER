package cn.zhouweiyao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.zhouweiyao.rest.dao.UserShopMapper;
import cn.zhouweiyao.rest.pojo.UserShop;
import cn.zhouweiyao.rest.pojo.UserShopExample;
import cn.zhouweiyao.rest.service.IUserShopService;
import cn.zhouweiyao.rest.vo.Msg;

@Service
public class UserShopServicce implements IUserShopService {

	@Autowired
	private UserShopMapper userShopMapper;

	@Override
	public UserShop getUserByPhone(String phone) {
		UserShopExample example = new UserShopExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<UserShop> users = userShopMapper.selectByExample(example);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public Msg saveUserShopRegister(String phone, String password) {
		/** phone、password为空；phone长度不够；password长度不在6-15位内 **/
		if (StringUtils.isBlank(phone) || StringUtils.isBlank(password) || phone.length() != 11 || password.length() < 6
				|| password.length() > 15) {
			return new Msg(1);
		}
		/** 用户存在 **/
		if (this.getUserByPhone(phone) != null) {
			return new Msg(1);
		}
		String digestPwd = DigestUtils.md5DigestAsHex(password.getBytes());

		UserShop record = new UserShop();
		record.setPhone(phone);
		record.setPassword(digestPwd);
		/** 注册默认没有填写店铺信息 **/
		record.setHasInf((byte) 0);

		userShopMapper.insert(record);
		return new Msg(0);

	}

	@Override
	public UserShop getUserByPhoneAndPassword(String phone, String password) {

		/** phone、password为空；phone长度不够；password长度不在6-15位内 **/
		if (StringUtils.isBlank(phone) || StringUtils.isBlank(password)) {
			return null;
		}
		UserShopExample example = new UserShopExample();
		example.createCriteria().andPhoneEqualTo(phone)
				.andPasswordEqualTo(DigestUtils.md5DigestAsHex(password.trim().getBytes()));
		List<UserShop> users = userShopMapper.selectByExample(example);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public Msg updatePassword(Integer user_id, String old_password, String new_password) {

		if (user_id == null) {
			return new Msg(1);
		}
		UserShop userShop = this.getUserById(user_id);
		if (userShop == null) {
			return new Msg(1);
		}
		if (StringUtils.isBlank(old_password) || StringUtils.isBlank(new_password) || new_password.length() < 6
				|| new_password.length() > 15) {
			return new Msg(1);
		}
		String oldPwd = DigestUtils.md5DigestAsHex(old_password.getBytes());
		if (!userShop.getPassword().equals(oldPwd)) {
			return new Msg(1);
		}
		String newPwd = DigestUtils.md5DigestAsHex(new_password.getBytes());
		userShop.setPassword(newPwd);
		userShopMapper.updateByPrimaryKey(userShop);
		return new Msg(0);
	}

	@Override
	public UserShop getUserById(Integer user_id) {
		return userShopMapper.selectByPrimaryKey(user_id);
	}

	@Override
	public Msg updatePhone(Integer user_id, String phone) {

		if (user_id == null) {
			return new Msg(1);
		}

		UserShop userShop = this.getUserById(user_id);
		if (userShop == null) {
			return new Msg(1);
		}

		if (StringUtils.isBlank(phone) || phone.length() != 11) {
			return new Msg(1);
		}

		userShop.setPhone(phone);
		userShopMapper.updateByPrimaryKey(userShop);

		return new Msg(0);
	}

}
