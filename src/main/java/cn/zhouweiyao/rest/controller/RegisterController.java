package cn.zhouweiyao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhouweiyao.rest.service.IUserShopService;
import cn.zhouweiyao.rest.vo.Msg;

/**
 * 注册 md5机密
 * 
 * @author Mr.Liang
 *
 */
@Controller()
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private IUserShopService userShopService;
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public Msg register(String phone, String password) {
		return userShopService.saveUserShopRegister(phone, password);
	}

}
