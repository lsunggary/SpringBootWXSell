package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    // 商品单价
    private Float productPrice;

    // 商品库存数
    private Integer productStock;

    // 商品图片
    private String productIcon;

    // 商品描述
    private String productDescription;

    // 商品种类
    private Integer categoryType;

    public ProductInfo() {
    }

    public ProductInfo(String productId, String productName, Float productPrice, Integer productStock, String productIcon, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productIcon = productIcon;
        this.categoryType = categoryType;
    }
}
