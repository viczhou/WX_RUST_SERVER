package cn.zhouweiyao.rest.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import cn.zhouweiyao.rest.beans.AccessToken;
import cn.zhouweiyao.rest.utils.JsonUtils;
import cn.zhouweiyao.rest.utils.NetHelper;

public class AccessTokenTask {
	private static final Logger log = LoggerFactory.getLogger(AccessToken.class);
	@Value("${APP_ID}")
	private String APP_ID;
	@Value("${APP_SECRET}")
	private String APP_SECRET;

	public static AccessToken accessToken = null;
	public static Long time = 0L;
	public void getMyAccessToken() {
		if (accessToken == null || time.equals(7000)) {
			accessToken = getAccessToken(APP_ID, APP_SECRET);
			/**复位**/
			time = 0L;
		}
		/**获取成功，token加50s**/
		if (accessToken != null) {
			time += 50L;
			log.info((7000l - time) + "s后再次获取token");
		}
	}
	
	/**
	 * 获取access_token
	 *
	 * @return AccessToken
	 */
	private AccessToken getAccessToken(String appId, String appSecret) {
		NetHelper netHelper = new NetHelper();
		/**
		 * 接口地址为https://api.weixin.qq.com/cgi-bin/token?grant_type=
		 * client_credential&appid=APPID&secret=APPSECRET，
		 * 其中grant_type固定写为client_credential即可。
		 */
		log.info("当前appID=" + appId + "----当前appSecret" + appSecret);
		String Url = String.format(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId.trim(),
				appSecret.trim());
		// 此请求为https的get请求，返回的数据格式为{"access_token":"ACCESS_TOKEN","expires_in":7200}
		String result = netHelper.getHttpsResponse(Url, "");
		log.info("获取到的access_token=" + result);
		AccessToken token = null;
		try {
			// 使用FastJson将Json字符串解析成Json对象
			token = JsonUtils.jsonToPojo(result, AccessToken.class);
		} catch (Exception e) {
			log.info("获取token失败：【原因】" + result);
			log.info(e.getMessage());
		}
		return token;
	}
}
