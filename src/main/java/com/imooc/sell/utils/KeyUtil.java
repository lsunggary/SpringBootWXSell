package com.imooc.sell.utils;

import com.sun.jmx.snmp.Timestamp;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName KeyUtil
 * @Description
 * @Author 47980
 * @Date 2020/3/13 23:35
 * @Version V_1.0
 **/
public class KeyUtil {

    public static String genUniqueKey() {
        Date date = new Date();
        long timelong = date.getTime();
        timelong += (long)(Math.random() * 64)<<8;
        return timelong + "";
    }
}