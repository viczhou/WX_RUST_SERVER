package cn.zhouweiyao.rest.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/utils")
public class UtilsController {

	private String appId = "wx84d3339d9842ade6";
	private String secretId = "2141ed76f1c6d6efb06ff66f9b928a9c";

	@RequestMapping(value = "/openId", method = RequestMethod.POST)
	@ResponseBody
	public String getOpenId(String js_code, HttpServletRequest request) {

		BufferedReader in = null;
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+this.appId+"&secret="+this.secretId+"&grant_type=authorization_code&js_code="+js_code;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			return new String(sb.toString());
		} catch (Exception e) {
			
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "";
	}
}
