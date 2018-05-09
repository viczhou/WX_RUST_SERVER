package cn.zhouweiyao.rest.vo;

import java.math.BigDecimal;

//'food_count':xxxxx ,
//'food_price':xxxxx,
//'food_name':xxxx
public class FoodVo {
	private Integer food_count;
	private BigDecimal food_price;
	private String food_name;
	public Integer getFood_count() {
		return food_count;
	}
	public void setFood_count(Integer food_count) {
		this.food_count = food_count;
	}
	public BigDecimal getFood_price() {
		return food_price;
	}
	public void setFood_price(BigDecimal food_price) {
		this.food_price = food_price;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public FoodVo(Integer food_count, BigDecimal food_price, String food_name) {
		super();
		this.food_count = food_count;
		this.food_price = food_price;
		this.food_name = food_name;
	}
	public FoodVo() {
		super();
	}
}
