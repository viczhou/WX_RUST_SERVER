package cn.zhouweiyao.rest.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 'show':-1,   //这个直接传-1 ，就好了
    'table':xx , //桌号
    'price':xxxx,   //订单价格
    'time':xxx， //下单时间
    'order_id'：xxx, //订单号
    'status':xx  //订单状态
    'detail':[{
         'image':xxxx, //菜品图片
         'count':xxx ,   //数量
         'price':xxx ,   //价格
         'name':xxxxx   //菜名
    },{
         ...
    }]
 * @author Mr.Liang
 *
 */
public class OrderPageVo {
	private Integer show;
	private Integer table;
	private BigDecimal price;
	private String time;
	private Integer order_id;
	private Byte status;
	private List<ShopOrderDetailVo> detail;
	public Integer getShow() {
		return show;
	}
	public void setShow(Integer show) {
		this.show = show;
	}
	public Integer getTable() {
		return table;
	}
	public void setTable(Integer table) {
		this.table = table;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public List<ShopOrderDetailVo> getDetail() {
		return detail;
	}
	public void setDetail(List<ShopOrderDetailVo> detail) {
		this.detail = detail;
	}
}
