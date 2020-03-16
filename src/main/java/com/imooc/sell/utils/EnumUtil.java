package com.imooc.sell.utils;

import com.imooc.sell.enums.BaseAbstractEnum;

/**
 * @ClassName EnumUtil
 * @Description
 * @Author 47980
 * @Date 2020/3/16 21:50
 * @Version V_1.0
 **/
public class EnumUtil {

    public static <T extends BaseAbstractEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
