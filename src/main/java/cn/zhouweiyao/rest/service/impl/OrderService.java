package cn.zhouweiyao.rest.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.zhouweiyao.rest.dao.OrderDetailMapper;
import cn.zhouweiyao.rest.dao.ShopFoodMapper;
import cn.zhouweiyao.rest.dao.ShopOrderMapper;
import cn.zhouweiyao.rest.pojo.OrderDetail;
import cn.zhouweiyao.rest.pojo.OrderDetailExample;
import cn.zhouweiyao.rest.pojo.ShopFood;
import cn.zhouweiyao.rest.pojo.ShopOrder;
import cn.zhouweiyao.rest.pojo.ShopOrderExample;
import cn.zhouweiyao.rest.pojo.ShopOrderExample.Criteria;
import cn.zhouweiyao.rest.service.IOrderService;
import cn.zhouweiyao.rest.vo.FoodVo;
import cn.zhouweiyao.rest.vo.Msg;
import cn.zhouweiyao.rest.vo.OrderDetailVo;
import cn.zhouweiyao.rest.vo.OrderPageVo;
import cn.zhouweiyao.rest.vo.ShopOrderCountVo;
import cn.zhouweiyao.rest.vo.ShopOrderDetailVo;
@Service
public class OrderService implements IOrderService{
	@Autowired
	private ShopOrderMapper shopOrderMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Autowired
	private ShopFoodMapper shopFoodMapper;
	@Override
	public ShopOrderCountVo getOrderCount(Integer shop_id) {
		
		ShopOrderExample example = new ShopOrderExample();
		Criteria crt = example.createCriteria();
		crt.andShopIdEqualTo(shop_id);
		int orderCount = shopOrderMapper.countByExample(example);
		crt.andOrderStatusEqualTo((byte)3);
		List<ShopOrder> results = shopOrderMapper.selectByExample(example);
		BigDecimal total_sales = new BigDecimal(0);
		for (ShopOrder s : results) {
			total_sales.add(s.getOrderPrice());
		}
		ShopOrderCountVo vo = new ShopOrderCountVo();
		vo.setMsg(0);
		vo.setOrder_count(orderCount);
		vo.setTotal_sales(total_sales);
		return vo;
	}
	@Override
	public List<OrderPageVo> getOrderPage(Integer shop_id, Integer limit, Integer page, Byte desc) {
		
		/**分页**/
		PageHelper.startPage(page, limit);
		ShopOrderExample orderExample = new ShopOrderExample();
		
		/**未处理订单**/
		if ( desc == (byte)0 ) {
			
			orderExample.createCriteria().andShopIdEqualTo(shop_id).andOrderStatusEqualTo((byte)0);
			
		} else if ( desc == (byte)1 ) {
			
			orderExample.createCriteria().andShopIdEqualTo(shop_id);
		
		} else if (desc == (byte) 2) {
			
			orderExample.createCriteria().andShopIdEqualTo(shop_id).andOrderStatusEqualTo((byte)1);
			
		}
		
		List<ShopOrder> orderResults = this.shopOrderMapper.selectByExample(orderExample);
		
		List<OrderPageVo> orderPageVos = new ArrayList<>();
		
		/**转换vo**/
		for (ShopOrder so : orderResults) {
			
			OrderPageVo vo = new OrderPageVo();
			vo.setShow(-1);
			vo.setTable(so.getTableNumber());
			vo.setPrice(so.getOrderPrice());
			vo.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(so.getOrderTime()));
			vo.setOrder_id(so.getId());
			vo.setStatus(so.getOrderStatus());
			
			/**查询菜色**/
			List<ShopOrderDetailVo> dt = new ArrayList<>();
			/**order详情**/
			OrderDetailExample detailExample = new OrderDetailExample();
			detailExample.createCriteria().andOrderIdEqualTo(so.getId());
			List<OrderDetail> orders = orderDetailMapper.selectByExample(detailExample);
			for (OrderDetail o : orders) {
				
				ShopOrderDetailVo dv = new ShopOrderDetailVo();
				dv.setCount(o.getFoodCount());
				/**菜色**/
				ShopFood food = this.shopFoodMapper.selectByPrimaryKey(o.getFoodId());
				dv.setImage(food.getFoodImg());
				dv.setName(food.getFoodName());
				dv.setPrice(food.getFoodPrice().multiply(new BigDecimal(o.getFoodCount())));
				
				dt.add(dv);
			}
			
			vo.setDetail(dt);
			
			orderPageVos.add(vo);
		}
		
		
		return orderPageVos;
	}
	@Override
	public OrderDetailVo getOrderDetail(Integer order_id) {
		OrderDetailExample example = new OrderDetailExample();
		example.createCriteria().andOrderIdEqualTo(order_id);
		List<OrderDetail> orders = this.orderDetailMapper.selectByExample(example );
		
		OrderDetailVo vo = new OrderDetailVo();
		ShopOrder order = getOrderById(order_id);
		if (order == null) {return new OrderDetailVo(1, null, null);}
		vo.setOrder_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getOrderTime()));
		vo.setOrder_price(order.getOrderPrice());
		
		vo.setMsg(0);
		vo.setOrder_status(order.getOrderStatus());
		
		List<FoodVo> foods = new ArrayList<>();
		for (OrderDetail od : orders) {
			
			ShopFood food = this.shopFoodMapper.selectByPrimaryKey(od.getFoodId());
			FoodVo fv = new FoodVo(od.getFoodCount(), food.getFoodPrice(), food.getFoodName());
			
			foods.add(fv);
		}
		
		vo.setOrder_detail(foods);
		return vo;
	}
	@Override
	public Msg changeStatusPay(Integer order_id) {
		
		ShopOrder shopOrder = this.getOrderById(order_id);
		shopOrder.setOrderStatus((byte)3);
		this.shopOrderMapper.updateByPrimaryKey(shopOrder);
		return new Msg(0);
	}
	@Override
	public ShopOrder getOrderById(Integer order_id) {
		return this.shopOrderMapper.selectByPrimaryKey(order_id);
	}

}
