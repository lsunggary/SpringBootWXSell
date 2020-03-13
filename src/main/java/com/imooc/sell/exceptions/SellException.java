package com.imooc.sell.exceptions;

import com.imooc.sell.enums.ResultEnum;
import lombok.Data;

/**
 * @ClassName SellException
 * @Description
 * @Author 47980
 * @Date 2020/3/13 22:48
 * @Version V_1.0
 **/
@Data
public class SellException extends RuntimeException  {
    private Integer code;

    private String message;

    public SellException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
    }
}
