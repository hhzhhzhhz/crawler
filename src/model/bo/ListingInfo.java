package model.bo;

import java.math.BigDecimal;

public class ListingInfo {

    private String ucid;

    private Integer houseType;
    //
    private BigDecimal houseCode;
    // 注册时间
    private Integer registerTime;
    // 面积
    private String area;
    // 总价
    private Integer totalPrice;
    // 单价
    private String price;
    // 房源ID
    private String houseId;
    // 区域ID
    private String resblockId;
    // 区域名称
    private String resblockName;
    // 地图位置
    private String resblockPosition;
    // 状态
    private Integer status;
    // 默认图片地址
    private String defaultImg;
    // 城市ID
    private String cityId;
    // 标题
    private String title;
    // 图片集合
    private String[] images;
    // 房源
    private String houseSource;

    public String getUcid() {
        return ucid;
    }

    public void setUcid(String ucid) {
        this.ucid = ucid;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public BigDecimal getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(BigDecimal houseCode) {
        this.houseCode = houseCode;
    }

    public Integer getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Integer registerTime) {
        this.registerTime = registerTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getResblockId() {
        return resblockId;
    }

    public void setResblockId(String resblockId) {
        this.resblockId = resblockId;
    }

    public String getResblockName() {
        return resblockName;
    }

    public void setResblockName(String resblockName) {
        this.resblockName = resblockName;
    }

    public String getResblockPosition() {
        return resblockPosition;
    }

    public void setResblockPosition(String resblockPosition) {
        this.resblockPosition = resblockPosition;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(String defaultImg) {
        this.defaultImg = defaultImg;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getHouseSource() {
        return houseSource;
    }

    public void setHouseSource(String houseSource) {
        this.houseSource = houseSource;
    }
}
