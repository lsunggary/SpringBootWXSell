package com.imooc.sell.exceptions;

/**
 * @ClassName SellExceptionHandle
 * @Description
 * @Author 47980
 * @Date 2020/3/13 23:19
 * @Version V_1.0
 **/

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> defaultErrorHandle(Exception e) {
        Map<String, Object> result = new HashMap<>();

        result.put("code", 500);
        result.put("message", e.getMessage());
        return result;
    }

    @ExceptionHandler(SellException.class)
    @ResponseBody
    public Map<String, Object> sellErrorHandle(SellException e) {
        Map<String, Object> result = new HashMap<>();

        result.put("code", e.getCode());
        result.put("message", e.getMessage());
        return result;
    }
}
