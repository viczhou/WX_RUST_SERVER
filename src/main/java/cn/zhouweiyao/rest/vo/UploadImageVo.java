package cn.zhouweiyao.rest.vo;

public class UploadImageVo {
	private Integer msg;
	private String img_src;
	public UploadImageVo() {
		super();
	}
	public UploadImageVo(Integer msg, String img_src) {
		super();
		this.msg = msg;
		this.img_src = img_src;
	}
	public Integer getMsg() {
		return msg;
	}
	public void setMsg(Integer msg) {
		this.msg = msg;
	}
	public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
}
