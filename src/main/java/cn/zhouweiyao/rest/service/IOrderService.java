package cn.zhouweiyao.rest.service;

import java.util.List;

import cn.zhouweiyao.rest.pojo.ShopOrder;
import cn.zhouweiyao.rest.vo.Msg;
import cn.zhouweiyao.rest.vo.OrderDetailVo;
import cn.zhouweiyao.rest.vo.OrderPageVo;
import cn.zhouweiyao.rest.vo.ShopOrderCountVo;

public interface IOrderService {
	ShopOrder getOrderById(Integer order_id);
	ShopOrderCountVo getOrderCount(Integer shop_id);
	List<OrderPageVo> getOrderPage(Integer shop_id, Integer limit, Integer page, Byte desc);
	OrderDetailVo getOrderDetail(Integer order_id);
	Msg changeStatusPay(Integer order_id);
}
