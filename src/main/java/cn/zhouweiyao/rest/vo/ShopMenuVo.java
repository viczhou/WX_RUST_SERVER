package cn.zhouweiyao.rest.vo;

public class ShopMenuVo {
	private Integer msg;
	private Integer menu_id;
	private String menu_name;
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public ShopMenuVo(Integer msg, Integer menu_id, String menu_name) {
		super();
		this.msg = msg;
		this.menu_id = menu_id;
		this.menu_name = menu_name;
	}
	public ShopMenuVo() {
		super();
	}
	public ShopMenuVo(Integer menu_id, String menu_name) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
	}
}
