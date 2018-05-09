package cn.zhouweiyao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhouweiyao.rest.dao.ShopMenuMapper;
import cn.zhouweiyao.rest.pojo.ShopMenu;
import cn.zhouweiyao.rest.pojo.ShopMenuExample;
import cn.zhouweiyao.rest.service.IShopMenuService;
import cn.zhouweiyao.rest.vo.AddMenuVo;
import cn.zhouweiyao.rest.vo.GetMenuVo;
import cn.zhouweiyao.rest.vo.Msg;
import cn.zhouweiyao.rest.vo.ShopMenuVo;

@Service
public class ShopMenuService implements IShopMenuService {
	@Autowired
	private ShopMenuMapper shopMenuMapper;

	@Override
	public AddMenuVo addMenu(Integer shop_id, String menu_content) {
		if (StringUtils.isBlank(menu_content)) {
			return new AddMenuVo(1, null);
		}
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setMenuName(menu_content);
		shopMenu.setShopId(shop_id);
		shopMenuMapper.insert(shopMenu);
		return new AddMenuVo(0, shopMenu.getId());
	}

	@Override
	public Msg deleteMenuById(Integer menu_id) {
		shopMenuMapper.deleteByPrimaryKey(menu_id);
		return new Msg(0);
	}

	@Override
	public GetMenuVo getMenuListByShopId(Integer shop_id) {

		ShopMenuExample example = new ShopMenuExample();
		example.createCriteria().andShopIdEqualTo(shop_id);
		List<ShopMenu> results = shopMenuMapper.selectByExample(example);

		/** Target **/
		List<ShopMenuVo> vos = new ArrayList<>();
		for (ShopMenu m : results) {

			ShopMenuVo vo = new ShopMenuVo(m.getId(), m.getMenuName());
			vos.add(vo);

		}
		GetMenuVo getVo = new GetMenuVo();
		getVo.setMsg(0);
		getVo.setMenu(vos);
		return getVo;
	}

}
