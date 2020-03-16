package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAMS_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ORDER_ERROR(12, "订单不正常"),
    ORDER_DETAIL_ERROR(13, "订单详情不正常"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_ERROR(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情不存在"),
    ORDER_PAY_STATUS_ERROR(17,"订单支付状态不正确"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_OWN_ERROR(19,"该订单不属于当前用户"),
    USER_ERROR(20, "用户名或密码错误"),
    USER_NOT_EXIST(21, "用户名不存在"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
