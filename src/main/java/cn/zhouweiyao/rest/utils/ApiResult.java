package cn.zhouweiyao.rest.utils;

import java.io.Serializable;
import java.util.HashMap;

//import com.alibaba.fastjson.JSON;



public class ApiResult extends HashMap<String, Object> implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String CODE = "code";// 响应状态码：0成功，非0为失败
	private static final String MSG = "msg";// 响应信息
	private static final String DATA = "data";// 响应数据
	
	public ApiResult() {
		this.put(CODE, 200);
		this.put(MSG, "0");
		
	}

	public ApiResult(Object obj) {
		this.put(CODE, 200);
		this.put(MSG, "0");
		
		this.put(DATA, obj);
	}

	public ApiResult(int errorCode, String errrMsg) {
		this.put(CODE, errorCode);
		this.put(MSG, errrMsg);
		
	}

	public int getCode() {
		return (Integer) get(CODE);
	}

	public String getMsg() {
		return (String) get(MSG);
	}



	public Object getData() {
		return get(DATA);
	}

	public void setData(Object obj) {
		this.put(DATA, obj);
	}
	public void setMsg(String msg) {
		this.put(MSG, msg);
	}

	public ApiResult append(String key, Object obj) {
		this.put(key, obj);
		return this;
	}

	/*public String toString(String callback) {
        String jsonString = JSON.toJSONString(this);  
		return callback+"("+jsonString+")";
	}
	*/
	
}
