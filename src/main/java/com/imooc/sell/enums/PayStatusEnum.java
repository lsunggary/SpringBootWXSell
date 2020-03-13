package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    NOT_PAID(0,"未支付"),
    PAID(1,"已支付"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
