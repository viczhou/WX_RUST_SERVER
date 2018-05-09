package cn.zhouweiyao.rest.vo;

import java.math.BigDecimal;

public class ShopOrderCountVo {
	private Integer msg;
	private BigDecimal total_sales;
	private Integer order_count;
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public BigDecimal getTotal_sales() {
		return total_sales;
	}
	public void setTotal_sales(BigDecimal total_sales) {
		this.total_sales = total_sales;
	}
	public Integer getOrder_count() {
		return order_count;
	}
	public void setOrder_count(Integer order_count) {
		this.order_count = order_count;
	}
}
