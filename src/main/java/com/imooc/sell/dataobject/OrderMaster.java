package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

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
    private BigDecimal orderAmount;

    // 订单状态 默认0，新下单，1,已接单，2，已取消
    private Integer orderStatus = OrderStatusEnum.INI.getCode();

    // 支付状态 默认0，未支付，1,已支付
    private Integer payStatus = PayStatusEnum.NOT_PAID.getCode();

    private Date createTime;

    private Date updateTime;

    public OrderMaster() {
    }

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus) {
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
