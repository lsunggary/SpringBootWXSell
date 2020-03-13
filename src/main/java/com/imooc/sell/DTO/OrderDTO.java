package com.imooc.sell.DTO;

import com.imooc.sell.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
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
}
