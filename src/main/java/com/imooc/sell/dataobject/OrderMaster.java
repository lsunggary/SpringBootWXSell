package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 订单
 */
@Entity
@Data
public class OrderMaster {

    @Id
    private String orderId;

    // 买家名称
    private String buyerName;

    // 买家电话
    private String buyerPhone;

    // 买家地址
    private String buyerAddress;

    // 买家微信openid
    private String buyerOpenid;

    // 订单总金额
    private Float orderAmount;

    // 订单状态 默认0，新下单
    private Integer orderStatus;

    // 支付状态 默认0，未支付
    private Integer payStatus;

    public OrderMaster() {
    }

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, Float orderAmount, Integer orderStatus, Integer payStatus) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
    }
}
