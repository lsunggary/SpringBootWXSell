package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ResultVO
 * @Description
 * @Author 47980
 * @Date 2020/3/14 14:59
 * @Version V_1.0
 **/
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private Object data;
}
