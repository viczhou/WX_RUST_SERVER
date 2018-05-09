package cn.zhouweiyao.rest.vo;
//{
//    'msg':0   (结果信息，0-success, 1-fail) ，
//    'order_price':xxxx ,
//    'order_time':xxx ,
//    'order_detail':[{
//         'food_count':xxxxx ,
//         'food_price':xxxxx,
//         'food_name':xxxx
//    },
//    {
//         ...
//    }]
//}

import java.math.BigDecimal;
import java.util.List;

public class OrderDetailVo {
	private Integer msg;
	private BigDecimal order_price;
	private String order_time;
	private Byte order_status;
	
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	
	private List<FoodVo> order_detail;
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public BigDecimal getOrder_price() {
		return order_price;
	}
	public void setOrder_price(BigDecimal order_price) {
		this.order_price = order_price;
	}
	public List<FoodVo> getOrder_detail() {
		return order_detail;
	}
	public void setOrder_detail(List<FoodVo> order_detail) {
		this.order_detail = order_detail;
	}
	public OrderDetailVo(Integer msg, BigDecimal order_price, List<FoodVo> order_detail) {
		super();
		this.msg = msg;
		this.order_price = order_price;
		this.order_detail = order_detail;
	}
	public OrderDetailVo() {
		super();
	}
	public Byte getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Byte order_status) {
		this.order_status = order_status;
	}
}
