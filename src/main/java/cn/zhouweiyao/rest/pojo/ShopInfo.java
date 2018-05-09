package cn.zhouweiyao.rest.pojo;

public class ShopInfo {
    private Integer id;

    private Integer userId;

    private String shopName;

    private String shopImg;

    private String shopAddress;

    private String shopPhone;

    private String shopLatitude;

    private String shopLongitude;

    private String shopLicence;

    private String respName;

    private String respPhone;

    private Byte shopStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg == null ? null : shopImg.trim();
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone == null ? null : shopPhone.trim();
    }

    public String getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(String shopLatitude) {
        this.shopLatitude = shopLatitude == null ? null : shopLatitude.trim();
    }

    public String getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(String shopLongitude) {
        this.shopLongitude = shopLongitude == null ? null : shopLongitude.trim();
    }

    public String getShopLicence() {
        return shopLicence;
    }

    public void setShopLicence(String shopLicence) {
        this.shopLicence = shopLicence == null ? null : shopLicence.trim();
    }

    public String getRespName() {
        return respName;
    }

    public void setRespName(String respName) {
        this.respName = respName == null ? null : respName.trim();
    }

    public String getRespPhone() {
        return respPhone;
    }

    public void setRespPhone(String respPhone) {
        this.respPhone = respPhone == null ? null : respPhone.trim();
    }

    public Byte getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Byte shopStatus) {
        this.shopStatus = shopStatus;
    }
}