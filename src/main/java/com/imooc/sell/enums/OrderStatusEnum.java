package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum implements BaseAbstractEnum {
    INI(0,"新建订单"),
    ACCEPT(1,"接受订单"),
    CANCEL(2,"取消订单")
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
