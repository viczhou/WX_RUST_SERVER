package cn.zhouweiyao.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 手机验证码
 * @author Mr.Liang
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhouweiyao.rest.vo.Msg;

@Controller
@RequestMapping("/validate_code")
public class ValidateCodeController {
	private static final String SESSION_CODE_NAME = "phone_code";
	private static final String CODE = "123456";
	/**
	 * 获取验证码
	 * @param phone
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getCode", method = RequestMethod.POST)
	@ResponseBody
	public Msg getValidateCode(String phone, HttpServletRequest request) {
		System.out.println(phone);
		if (StringUtils.isBlank(phone) || phone.length() != 11) {
			return new Msg(1);
		}
		request.getSession().setAttribute(SESSION_CODE_NAME, CODE);
		return new Msg(0);

	}

	/**
	 * 验证验证码
	 * @param phone
	 * @param code
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	@ResponseBody
	public Msg validateCode(String phone, String code, HttpServletRequest request) {
		System.out.println(phone + "-------------" + code);
		if (StringUtils.isBlank(phone) || StringUtils.isBlank(code) || phone.length() != 11) {

			return new Msg(1);

		}

//		String sessionCode = (String) request.getSession().getAttribute(SESSION_CODE_NAME);
//		if (StringUtils.isBlank(sessionCode) || !sessionCode.equals(code)) {
//			return new Msg(1);
//		}
		
		if (!code.equals(CODE)) {
			
			return new Msg(1);
			
		}

		return new Msg(0);
	}
}
