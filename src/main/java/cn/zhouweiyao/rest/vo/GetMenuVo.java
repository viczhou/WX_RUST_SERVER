package cn.zhouweiyao.rest.vo;

import java.util.List;

public class GetMenuVo {
	private Integer msg;
	private List<ShopMenuVo> menu;
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public List<ShopMenuVo> getMenu() {
		return menu;
	}
	public void setMenu(List<ShopMenuVo> menu) {
		this.menu = menu;
	}
}
