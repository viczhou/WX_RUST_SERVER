package cn.zhouweiyao.rest.pojo;

public class UserShop {
    private Integer id;

    private String phone;

    private String password;

    private Byte hasInf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getHasInf() {
        return hasInf;
    }

    public void setHasInf(Byte hasInf) {
        this.hasInf = hasInf;
    }
}