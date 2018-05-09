package cn.zhouweiyao.rest.vo;

public class LoginVo {
	private Integer msg;
	private Integer shop_id;
	private Integer user_id;
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public LoginVo(Integer msg, Integer shop_id, Integer user_id) {
		super();
		this.msg = msg;
		this.shop_id = shop_id;
		this.user_id = user_id;
	}
	public LoginVo() {
		super();
	}
}
