package com.imooc.sell.service;

import com.imooc.sell.DTO.OrderDTO;

/**
 * @ClassName BuyerService
 * @Description interface
 * @Author 47980
 * @Date 2020/3/14 16:42
 * @Version V_1.0
 **/
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
