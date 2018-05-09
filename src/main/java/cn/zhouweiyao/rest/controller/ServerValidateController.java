package cn.zhouweiyao.rest.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 服务器验证
 * 验证地址：部署地址/应用地址/server/validate
 * @author Mr.Liang
 *
 */
@Controller
public class ServerValidateController {
	@Value("${TOKEN}")
	private String TOKEN;

	/**
	 * 1)将token、timestamp、nonce三个参数进行字典序排序 
	 * 2）将三个参数字符串拼接成一个字符串进行sha1加密
	 * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * 
	 * @param signature
	 *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @param echostr
	 *            随机字符串
	 * @return
	 */
	@RequestMapping("/server/validate")
	@ResponseBody
	public String validateServer(String signature, String timestamp, String nonce, String echostr) {

		String sortStr = this.sort(TOKEN, timestamp, nonce);
		String sha1Str = this.sha1(sortStr);

		if (StringUtils.isNotBlank(sha1Str) && sha1Str.equals(signature)) {

			System.out.println("校验成功！！！");
			return echostr;

		}

		return "";

	}

	/**
	 * 排序
	 * 
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	private String sort(String token, String timestamp, String nonce) {
		String[] strArray = { token, timestamp, nonce };
		Arrays.sort(strArray);
		StringBuilder sb = new StringBuilder();
		for (String str : strArray) {
			sb.append(str);
		}

		return sb.toString();
	}

	/**
	 * 将字符串进行sha1加密
	 *
	 * @param str
	 *            需要加密的字符串
	 * @return 加密后的内容
	 */
	private String sha1(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(str.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
}
