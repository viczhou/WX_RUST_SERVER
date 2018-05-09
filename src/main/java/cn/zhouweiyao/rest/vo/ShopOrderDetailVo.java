package cn.zhouweiyao.rest.vo;

import java.math.BigDecimal;

/**
 *  'detail':[{
         'image':xxxx, //菜品图片
         'count':xxx ,   //数量
         'price':xxx ,   //价格
         'name':xxxxx   //菜名
    }
 * @author Mr.Liang
 *
 */
public class ShopOrderDetailVo {
	private String image;
	private Integer count;
	private BigDecimal price;
	private String name;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ShopOrderDetailVo(String image, Integer count, BigDecimal price, String name) {
		super();
		this.image = image;
		this.count = count;
		this.price = price;
		this.name = name;
	}
	public ShopOrderDetailVo() {
		super();
	}
}
