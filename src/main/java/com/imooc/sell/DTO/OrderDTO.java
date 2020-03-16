package com.imooc.sell.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description
 * @Author 47980
 * @Date 2020/3/13 22:14
 * @Version V_1.0
 **/
@Data
public class OrderDTO {

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

    // 订单状态 默认0，新下单
    private Integer orderStatus;

    // 支付状态 默认0，未支付
    private Integer payStatus;

    // 创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    // 更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    // 订单-商品详情列表
    private List<OrderDetail> orderDetailList;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus, List<OrderDetail> orderDetailList) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
        this.orderDetailList = orderDetailList;
    }

    private OrderStatusEnum orderStatusEnum;

    private PayStatusEnum payStatusEnum;

    /**
     * @JsonIgnore 返回值忽略此方法
     * @return
     */
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum () {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum () {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
