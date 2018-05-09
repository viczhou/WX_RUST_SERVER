package cn.zhouweiyao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhouweiyao.rest.service.IShopMenuService;
import cn.zhouweiyao.rest.vo.AddMenuVo;
import cn.zhouweiyao.rest.vo.GetMenuVo;
import cn.zhouweiyao.rest.vo.Msg;

/**
 * 分类菜单
 * 
 * @author Mr.Liang
 *
 */
@Controller
@RequestMapping("/shop_menu")
public class ShopMenuController {

	@Autowired
	private IShopMenuService shopMenuService;

	/**
	 * 添加菜单
	 * 
	 * @param shop_id
	 * @param menu_content
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public AddMenuVo addMenu(Integer shop_id, String menu_content) {
		return shopMenuService.addMenu(shop_id, menu_content);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Msg deleteMenu(Integer menu_id) {
		return shopMenuService.deleteMenuById(menu_id);
	}

	@RequestMapping(value = "/getMenu", method = RequestMethod.POST)
	@ResponseBody
	public GetMenuVo getMenu(Integer shop_id) {
		return shopMenuService.getMenuListByShopId(shop_id);
	}
}
