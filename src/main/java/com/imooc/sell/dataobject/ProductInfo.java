package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    // 商品单价
    private BigDecimal productPrice;

    // 商品库存数
    private Integer productStock;

    // 商品图片
    private String productIcon;

    // 商品上下架 0：下架，1：上架
    private Integer productStatus;

    // 商品描述
    private String productDescription;

    // 商品种类
    private Integer categoryType;

    public ProductInfo() {
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productIcon, Integer productStatus, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.productDescription = productDescription;
    }
}
