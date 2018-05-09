package cn.zhouweiyao.rest.vo;
/**
 *  'msg': 0 , //0-success , 1-fail
	    'shop_name':'xxxxx',
	    'shop_phone':'xxxxxx',
        'shop_address' : 'xxxxxxxxx',
        'atitude':xxxxxx,
        'longitude':xxxxx,
        'shop_img' : 'xxxx' //店铺头像，图片name
        'shop_status':xxxx
 * @author Mr.Liang
 *
 */
public class ShopInfoVo {
	
	private Integer msg;
	private String shop_name;
	private String shop_phone;
	private String shop_address;
	private String atitude;
	private String longitude;
	private String shop_img;
	private Byte shop_status;
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_phone() {
		return shop_phone;
	}
	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getAtitude() {
		return atitude;
	}
	public void setAtitude(String atitude) {
		this.atitude = atitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getShop_img() {
		return shop_img;
	}
	public void setShop_img(String shop_img) {
		this.shop_img = shop_img;
	}
	public Byte getShop_status() {
		return shop_status;
	}
	public void setShop_status(Byte shop_status) {
		this.shop_status = shop_status;
	}
	public ShopInfoVo(Integer msg, String shop_name, String shop_phone, String shop_address, String atitude,
			String longitude, String shop_img, Byte shop_status) {
		super();
		this.msg = msg;
		this.shop_name = shop_name;
		this.shop_phone = shop_phone;
		this.shop_address = shop_address;
		this.atitude = atitude;
		this.longitude = longitude;
		this.shop_img = shop_img;
		this.shop_status = shop_status;
	}
	public ShopInfoVo(Integer msg) {
		super();
		this.msg = msg;
	}
	public ShopInfoVo() {
		super();
	}
}
