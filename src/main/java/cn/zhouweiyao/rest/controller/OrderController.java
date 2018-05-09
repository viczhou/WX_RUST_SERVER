package cn.zhouweiyao.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhouweiyao.rest.service.IOrderService;
import cn.zhouweiyao.rest.vo.Msg;
import cn.zhouweiyao.rest.vo.OrderDetailVo;
import cn.zhouweiyao.rest.vo.OrderPageVo;
import cn.zhouweiyao.rest.vo.ShopOrderCountVo;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	@RequestMapping(value="/getShopOrderCount", method = RequestMethod.POST)
	@ResponseBody
	public ShopOrderCountVo getShopOrderCount(Integer shop_id){
		return orderService.getOrderCount(shop_id);
	}
	
	/**
	 * 'shop_id':'xxxxx',
	'limit':50, //分页条数，50条默认
    'page' :xx ，  //页码
    'desc' ： 0 // 0-未处理订单， 1 全部订单 ， 2-未结账订单
	 */
	@RequestMapping(value="/getShopOrderPage", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderPageVo> getPage(Integer shop_id, @RequestParam(defaultValue = "50") Integer limit, @RequestParam(defaultValue="1") Integer page, Byte desc){
		
		return orderService.getOrderPage(shop_id, limit, page, desc);
		
	}
	@RequestMapping(value = "/getOrderDetail", method = RequestMethod.POST)
	@ResponseBody
	public OrderDetailVo getDetail(Integer order_id) {
		return this.orderService.getOrderDetail(order_id);
	}
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	@ResponseBody
	public Msg pay(Integer order_id) {
		
		return this.orderService.changeStatusPay(order_id);
		
	}
}
