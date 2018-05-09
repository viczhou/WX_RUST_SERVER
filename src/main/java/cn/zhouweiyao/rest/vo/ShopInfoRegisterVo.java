package cn.zhouweiyao.rest.vo;

public class ShopInfoRegisterVo {
	private Integer msg;
	private Integer shop_id;
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
	public ShopInfoRegisterVo() {
		super();
	}
	public ShopInfoRegisterVo(Integer msg, Integer shop_id) {
		super();
		this.msg = msg;
		this.shop_id = shop_id;
	}
}
