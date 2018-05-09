package cn.zhouweiyao.rest.service;

import cn.zhouweiyao.rest.vo.AddMenuVo;
import cn.zhouweiyao.rest.vo.GetMenuVo;
import cn.zhouweiyao.rest.vo.Msg;

public interface IShopMenuService {
	
	AddMenuVo addMenu(Integer shop_id, String menu_content);
	
	Msg deleteMenuById(Integer menu_id);
	
	GetMenuVo getMenuListByShopId(Integer shop_id);
	
}
