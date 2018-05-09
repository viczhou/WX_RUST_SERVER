package cn.zhouweiyao.rest.vo;
//{
//    'msg':0   (结果信息，0-success, 1-fail) ，
//    'food_id':xxxxx
//}
public class AddFoodVo {
	private Integer msg;
	private Integer food_id;
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public Integer getFood_id() {
		return food_id;
	}
	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}
	public AddFoodVo(Integer msg, Integer food_id) {
		super();
		this.msg = msg;
		this.food_id = food_id;
	}
	public AddFoodVo() {
		super();
	}
}
