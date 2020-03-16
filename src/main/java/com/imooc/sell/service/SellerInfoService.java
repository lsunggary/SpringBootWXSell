package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

/**
 * @ClassName SellerInfoService
 * @Description interface
 * @Author 47980
 * @Date 2020/3/16 22:23
 * @Version V_1.0
 **/
public interface SellerInfoService {

    SellerInfo findOne(String username);

    SellerInfo check(String username, String password);

    SellerInfo save(SellerInfo sellerInfo);
}
