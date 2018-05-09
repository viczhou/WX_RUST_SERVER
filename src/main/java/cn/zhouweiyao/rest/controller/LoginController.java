package cn.zhouweiyao.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhouweiyao.rest.pojo.ShopInfo;
import cn.zhouweiyao.rest.pojo.UserShop;
import cn.zhouweiyao.rest.service.IShopInfoService;
import cn.zhouweiyao.rest.service.IUserShopService;
import cn.zhouweiyao.rest.vo.LoginVo;
import cn.zhouweiyao.rest.vo.Msg;

/**
 * 登陆
 * @author Mr.Liang
 *
 */
@Controller()
@RequestMapping("/login")
public class LoginController {
	private static final String USER_SHOP_NAME = "user_shop";
	@Autowired
	private IUserShopService userShopService;
	@Autowired
	private IShopInfoService shopInfoService;
	
	/**
	 * 登陆
	 * @param phone
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public LoginVo login(String phone, String password, HttpServletRequest request) {
		UserShop userShop = userShopService.getUserByPhoneAndPassword(phone, password);
		if (userShop == null) {
			return new LoginVo(1, -1, -1);
		}
		request.getSession().setAttribute(USER_SHOP_NAME, userShop);
		ShopInfo shopInfo = shopInfoService.getShopInfoByUserId(userShop.getId());
		if (shopInfo == null) {
			return new LoginVo(2, -1, userShop.getId());
		}
		return new LoginVo(0, shopInfo.getId(), userShop.getId());
		
	}
	/**
	 * 修改密码
	 * @param user_id
	 * @param old_password
	 * @param new_password
	 * @return
	 */
	@RequestMapping(value = "/change_pwd", method = RequestMethod.POST)
	@ResponseBody
	public Msg changePassword(Integer user_id, String old_password, String new_password) {
		
		return userShopService.updatePassword(user_id, old_password, new_password);
		
	}
	/**
	 * 修改手机号码
	 * @param user_id
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/chang_phone", method = RequestMethod.POST)
	@ResponseBody
	public Msg changePhone(Integer user_id, String phone) {
		return userShopService.updatePhone(user_id, phone);
	}
	
}
