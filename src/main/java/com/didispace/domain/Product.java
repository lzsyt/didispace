package com.didispace.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "product")
public class Product {


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", creater='" + creater + '\'' +
                ", productSynopsis='" + productSynopsis + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", isdelet='" + isdelet + '\'' +
                ", productType=" + productType +
                ", type=" + type +
                ", productNum='" + productNum + '\'' +
                '}';
    }

    @Id
    private Integer productId;

    private String productName;

    private BigDecimal price;

    private String creater;

    private String productSynopsis;

    private String productDescription;

    private String isdelet;

    private Integer productType;

    private Integer type;

    private String productNum;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getProductSynopsis() {
        return productSynopsis;
    }

    public void setProductSynopsis(String productSynopsis) {
        this.productSynopsis = productSynopsis == null ? null : productSynopsis.trim();
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
    }

    public String getIsdelet() {
        return isdelet;
    }

    public void setIsdelet(String isdelet) {
        this.isdelet = isdelet == null ? null : isdelet.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum == null ? null : productNum.trim();
    }
}