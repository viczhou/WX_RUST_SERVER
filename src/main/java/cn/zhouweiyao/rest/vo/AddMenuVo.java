package cn.zhouweiyao.rest.vo;

public class AddMenuVo {
	private Integer msg;
	private Integer menu_id;
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
	public AddMenuVo(Integer msg, Integer menu_id) {
		super();
		this.msg = msg;
		this.menu_id = menu_id;
	}
	public AddMenuVo() {
		super();
	}
}
