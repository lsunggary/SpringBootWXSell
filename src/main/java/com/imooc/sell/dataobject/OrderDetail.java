package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 订单详情
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    // 订单ID
    private String orderId;

    private String productId;

    private String productName;

    // 商品单价
    private Float productPrice;

    // 订单商品数量
    private Integer productQuantity;

    // 商品小图
    private String ProductIcon;

    public OrderDetail() {
    }

    public OrderDetail(String detailId, String orderId, String productId, String productName, Float productPrice, Integer productQuantity, String productIcon) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        ProductIcon = productIcon;
    }
}
